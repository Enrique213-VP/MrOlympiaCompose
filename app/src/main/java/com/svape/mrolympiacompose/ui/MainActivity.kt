package com.svape.mrolympiacompose.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.svape.mrolympiacompose.core.ConnectionStatus
import com.svape.mrolympiacompose.core.currentConnectivityStatus
import com.svape.mrolympiacompose.core.observeConnectivityAsFlow
import com.svape.mrolympiacompose.data.api.model.ClassicPhysique
import com.svape.mrolympiacompose.ui.about_me.AboutMeActivity
import com.svape.mrolympiacompose.ui.home.HomeSc
import com.svape.mrolympiacompose.ui.network.UnavailableScreen
import com.svape.mrolympiacompose.ui.profile.ProfileActivity
import com.svape.mrolympiacompose.ui.theme.MrOlympiaComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MrOlympiaComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home {
                        startActivity(ProfileActivity.newIntent(this, it))
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun Home(navigateToProfile: (ClassicPhysique) -> Unit) {
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues)
            ) {
                CheckConnectivityStatus(navigateToProfile = navigateToProfile)
            }
        }
    )
}

@Composable
fun FloatingActionButtons() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(end = 40.dp, bottom = 30.dp),

        // on below line we are adding vertical
        // arrangement and horizontal alignment.
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End,
    ) {

        // on below line we are creating
        // a simple floating action button
        FloatingActionButton(
            // on below line we are adding on click for our fab
            onClick = {
                val intent = Intent(context, AboutMeActivity::class.java)
                context.startActivity(intent)
                //val  intent = Intent(this, AboutMeActivity::class.java)
                Toast.makeText(context, "Un poco sobre mí", Toast.LENGTH_SHORT).show()
            },
            // on below line we are adding content color for our button
            containerColor = Color.Gray,
            contentColor = Color.White
        ) {
            // on below line we are
            // adding icon for button.
            Icon(Icons.Filled.Face, contentDescription = "About me")
        }
    }
}


@ExperimentalCoroutinesApi
@Composable
fun CheckConnectivityStatus(navigateToProfile: (ClassicPhysique) -> Unit) {
    val connection by connectivityStatus()

    val isConnected = connection === ConnectionStatus.Available

    if(isConnected){
        HomeSc(navigateToProfile = navigateToProfile)
    } else {
        UnavailableScreen()
    }
}

@ExperimentalCoroutinesApi
@Composable
fun connectivityStatus(): State<ConnectionStatus> {
    val mCtx = LocalContext.current

    return produceState(initialValue = mCtx.currentConnectivityStatus) {
        mCtx.observeConnectivityAsFlow().collect { value = it }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "La $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MrOlympiaComposeTheme {
        Greeting("Wena")
    }
}