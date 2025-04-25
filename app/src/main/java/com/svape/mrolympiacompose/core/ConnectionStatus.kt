package com.svape.mrolympiacompose.core

sealed class ConnectionStatus {
    data object Available: ConnectionStatus()
    data object Unavailable: ConnectionStatus()
}