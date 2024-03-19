package com.svape.mrolympiacompose

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
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.svape.mrolympiacompose.data.api.model.ClassicPhysique
import com.svape.mrolympiacompose.ui.about_me.AboutMeActivity
import com.svape.mrolympiacompose.ui.home.HomeSc
import com.svape.mrolympiacompose.ui.profile.ProfileActivity
import com.svape.mrolympiacompose.ui.theme.MrOlympiaComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MrOlympiaComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Home {
                        startActivity(ProfileActivity.newIntent(this, it))
                    }
                }
            }
        }
    }
}

@Composable
fun Home(navigateToProfile: (ClassicPhysique) -> Unit) {
    Scaffold(
        content = {
            HomeSc(navigateToProfile = navigateToProfile)
        }
    )
}

@Composable
fun FloatingActionButtons() {
    val context = LocalContext.current

    // on the below line we are creating a column.
    Column(
        // on below line we are adding a modifier to it
        // and setting max size, max height and max width
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
            // on below line we are adding
            // background color for our button
            backgroundColor = Color.Gray,
            // on below line we are adding
            // color for our content of fab.
            contentColor = MaterialTheme.colors.surface
        ) {
            // on below line we are
            // adding icon for button.
            Icon(Icons.Filled.Face, "")
        }
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