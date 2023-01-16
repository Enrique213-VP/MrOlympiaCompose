package com.svape.mrolympiacompose.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.svape.mrolympiacompose.data.api.model.ClassicPhysique


@Composable
fun HomeSc() {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by homeViewModel.state.collectAsState()

    LazyColumn {
        if (state.isEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }
        }

        items(state) { classic: ClassicPhysique ->
            OlympiaImageCard(classicPhysique = classic)
        }

    }
}

@Composable
fun OlympiaImageCard(classicPhysique: ClassicPhysique) {

    val imagerPainter = rememberAsyncImagePainter(model = classicPhysique.imageTa)

    Card(shape = MaterialTheme.shapes.medium, modifier = Modifier.padding(16.dp)) {

        Box {
            Image(
                painter = imagerPainter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.FillBounds
            )
            androidx.compose.material.Surface(
                color = MaterialTheme.colors.surface.copy(alpha = .3f),
                modifier = Modifier.align(Alignment.BottomCenter),
                contentColor = MaterialTheme.colors.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Text(
                        text = "${classicPhysique.name}",
                        color = Color.Magenta
                    )
                    Text(text = "${classicPhysique.nationality}")
                    Text(text = "Mr Olympias wins: ${classicPhysique.winMisterOlympia}")
                }
            }
        }
    }
}