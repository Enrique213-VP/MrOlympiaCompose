package com.svape.mrolympiacompose.ui.about_me

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.svape.mrolympiacompose.Greeting
import com.svape.mrolympiacompose.R

import com.svape.mrolympiacompose.ui.theme.MrOlympiaComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutMeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MrOlympiaComposeTheme {
                AboutMeContent()
            }
        }
    }
}


@Composable
fun AboutMeContent() {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .wrapContentSize(Alignment.TopCenter)
        ) {
            // Agregar título encima de la imagen
            Text(
                text = "Sergio Vargas",
                style = MaterialTheme.typography.h5,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Agregar imagen de perfil centrada
            Image(
                painter = painterResource(id = R.drawable.myself),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .padding(bottom = 16.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )

            // Agregar texto descriptivo sobre ti
            Text(
                text = "¡Bienvenido!\nSoy un entusiasta desarrollador de aplicaciones móviles. Me encanta programar y crear experiencias increíbles para los usuarios.",
                style = MaterialTheme.typography.body1,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Agregar botón de LinkedIn
            Button(
                onClick = { /* Acción al hacer clic en el botón de LinkedIn */ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .background(MaterialTheme.colors.surface)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.linkedin),
                        contentDescription = "LinkedIn Logo",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "LinkedIn", color = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MrOlympiaComposeTheme {
        Greeting("Wena")
    }
}