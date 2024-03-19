package com.svape.mrolympiacompose.ui.profile

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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.svape.mrolympiacompose.R
import com.svape.mrolympiacompose.data.api.model.ClassicPhysique


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

        // Add a spacer that always shows part (320.dp) of the fields list regardless of the device,
        // in order to always leave some content at the top.
        Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
private fun Title(classicPhysique: ClassicPhysique) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = classicPhysique.name,
            style = MaterialTheme.typography.h5,
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
            style = MaterialTheme.typography.h6.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp // Adjust the size as needed
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.overline,
            overflow = TextOverflow.Visible,
            fontSize = 15.sp // Adjust the size as needed
        )
    }
}