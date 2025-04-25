package com.svape.mrolympiacompose.ui.profile

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.svape.mrolympiacompose.R
import com.svape.mrolympiacompose.data.api.model.ClassicPhysique
import com.svape.mrolympiacompose.ui.MainActivity


@Composable
fun ProfileDetail(classicPhysique: ClassicPhysique) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {
                    //TODO:
                    ProfileHeader(
                        classicPhysique = classicPhysique,
                        containerHeight = this@BoxWithConstraints.maxHeight
                    )
                    ProfileContent(
                        classicPhysique, this@BoxWithConstraints.maxHeight
                    )
                }
            }
        }
    }
}


@Composable
private fun ProfileHeader(
    classicPhysique: ClassicPhysique,
    containerHeight: Dp
) {
    val imagerPainter = rememberAsyncImagePainter(model = classicPhysique.imageP)

    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth(),
        painter = imagerPainter,
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
private fun ProfileContent(classicPhysique: ClassicPhysique, containerHeight: Dp) {

    val context = LocalContext.current

    Column {
        Title(classicPhysique)
        ProfileProperty(
            label = stringResource(id = R.string.nickname),
            value = classicPhysique.nickname
        )
        ProfileProperty(
            label = stringResource(id = R.string.birth),
            value = classicPhysique.birth.toString()
        )
        ProfileProperty(
            label = stringResource(id = R.string.nationality),
            value = classicPhysique.nationality
        )
        ProfileProperty(
            label = stringResource(id = R.string.achievement),
            value = classicPhysique.achievement
        )
        Button(
            onClick = {
                val intent = Intent(context, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                context.startActivity(intent)
                // Finalizar la actividad actual
                (context as Activity).finish()
            },
            modifier = Modifier
                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(android.graphics.Color.parseColor("#808080"))
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
        //More Space in the view
        //Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
private fun Title(classicPhysique: ClassicPhysique) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = classicPhysique.name,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun ProfileProperty(label: String, value: String) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text = label,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodySmall,
            overflow = TextOverflow.Visible,
            fontSize = 15.sp
        )
    }
}