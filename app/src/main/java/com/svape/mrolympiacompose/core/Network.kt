package com.svape.mrolympiacompose.core

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.annotation.RequiresPermission
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow


val Context.currentConnectivityStatus: ConnectionStatus
    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    get() {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return getCurrentConnectivityStatus(connectivityManager)
    }

@RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
fun getCurrentConnectivityStatus(
    connectivityManager: ConnectivityManager
): ConnectionStatus {

    val connected = connectivityManager.allNetworks.any() { network ->
        connectivityManager.getNetworkCapabilities(network)
            ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            ?: false
    }

    return if (connected) {
        ConnectionStatus.Available
    } else {
        ConnectionStatus.Unavailable
    }
}


fun Context.observeConnectivityAsFlow() = callbackFlow {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val callback = NetworkCallback { connectionState ->
        trySend(connectionState)
    }

    val networkRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .build()

    connectivityManager.registerNetworkCallback(networkRequest, callback)

    val currentState = getCurrentConnectivityStatus(connectivityManager)
    trySend(currentState)

    awaitClose {
        connectivityManager.unregisterNetworkCallback(callback)
    }
}

fun NetworkCallback(callback: (ConnectionStatus) -> Unit): ConnectivityManager.NetworkCallback {
    return object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            callback(ConnectionStatus.Available)
        }

        override fun onUnavailable() {
            callback(ConnectionStatus.Unavailable)
        }
    }
}
