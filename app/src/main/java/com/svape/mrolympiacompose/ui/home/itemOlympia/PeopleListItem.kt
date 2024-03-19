package com.svape.mrolympiacompose.ui.home.itemOlympia

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.svape.mrolympiacompose.data.api.model.ClassicPhysique

@Composable
fun PeopleListItem(classicPhysique: ClassicPhysique, navigateToProfile: (ClassicPhysique) -> Unit) {

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(
            Modifier.clickable { navigateToProfile(classicPhysique) }
        ) {
            PeopleImage(classicPhysique = classicPhysique)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = classicPhysique.nickname, style = MaterialTheme.typography.h6)
                Text(text = classicPhysique.nationality, style = MaterialTheme.typography.caption)
            }
        }
    }
}


@Composable
private fun PeopleImage(classicPhysique: ClassicPhysique) {

    val imagerPainter = rememberAsyncImagePainter(model = classicPhysique.imageTa)

    Image(
        painter = imagerPainter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}