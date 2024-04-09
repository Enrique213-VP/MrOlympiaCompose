package com.svape.mrolympiacompose.ui.about_me

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.WindowInsetsCompat
import com.svape.mrolympiacompose.R
import com.svape.mrolympiacompose.MainActivity
import com.svape.mrolympiacompose.ui.theme.MrOlympiaComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutMeActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ocultar la ActionBar
        window.decorView.windowInsetsController?.hide(WindowInsetsCompat.Type.statusBars())
        actionBar?.hide()

        setContent {
            MrOlympiaComposeTheme {
                AboutMeContent()
            }
        }
    }
}


@Composable
fun AboutMeContent() {
    val context = LocalContext.current

    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color(android.graphics.Color.parseColor("#202124")))
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .height(500.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = "Background Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .align(Alignment.TopCenter),
                    contentScale = ContentScale.Crop
                )
                // image profile
                Image(
                    painter = painterResource(id = R.drawable.myself),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(50))
                        .border(
                            width = 4.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(50)
                        )
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = "¡Bienvenido!",
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontSize = 30.sp
                ),
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // about me
            Text(
                text = "Me llamo Sergio Vargas \n Soy desarrollador de aplicaciones moviles nativas en android, con experiencia en proyectos a gran escala. Me apasiona programar y crear experiencias increíbles para los usuarios.",
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontSize = 15.sp,
                    lineHeight = 20.sp
                ),
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(
                    start = 32.dp,
                    end = 32.dp,
                    top = 10.dp,
                    bottom = 10.dp
                )
            )

            // about app
            Text(
                text = "Esta aplicacion esta diseñada para mostrar algunos de los campeones de los olympia y gente que conozco, si tienes ideas para agregar a futuras versiones me puedes contactar por mi redes social, agradezco que hayas descargado la app y espero te guste.",
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontSize = 15.sp,
                    lineHeight = 20.sp
                ),
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(
                    start = 32.dp,
                    end = 32.dp,
                    top = 10.dp,
                    bottom = 10.dp
                )
            )

            Button(
                onClick = {
                    // Acción al hacer clic en el botón de LinkedIn
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("https://www.linkedin.com/in/svap/")
                    startActivity(context, intent, null)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                    .height(55.dp), colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(android.graphics.Color.parseColor("#0366c3"))
                ),
                shape = RoundedCornerShape(15)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.linkedin),
                        contentDescription = "LinkedIn Logo",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "LinkedIn",
                        color = Color.White,
                        style = TextStyle(
                            fontFamily = FontFamily.Monospace,
                            fontSize = 15.sp,
                            lineHeight = 20.sp
                        )
                    )
                }
            }

            Button(
                onClick = {
                    // Acción al hacer clic en el botón de Instagram
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("https://www.instagram.com/sergio_hidden/")
                    startActivity(context, intent, null)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                    .height(55.dp), colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(android.graphics.Color.parseColor("#3f729b"))
                ),
                shape = RoundedCornerShape(15)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.instagram),
                        contentDescription = "Instagram Logo",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Instagram",
                        color = Color.White,
                        style = TextStyle(
                            fontFamily = FontFamily.Monospace,
                            fontSize = 15.sp,
                            lineHeight = 20.sp
                        )
                    )
                }
            }

            Button(
                onClick = {
                    val intent = Intent(context, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                    context.startActivity(intent)
                    (context as Activity).finish()
                },
                Modifier
                    .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                    .fillMaxWidth()
                    .height(60.dp), colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(android.graphics.Color.parseColor("#808080"))
                ),
                shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = "Ir al inicio",
                    color = Color.White,
                    style = TextStyle(
                        fontFamily = FontFamily.Monospace,
                        fontSize = 15.sp,
                        lineHeight = 20.sp
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MrOlympiaComposeTheme {
        AboutMeContent()
    }
}