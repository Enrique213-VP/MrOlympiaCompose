package com.svape.mrolympiacompose.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.svape.mrolympiacompose.core.Constants.LIST_TEST_TAG
import com.svape.mrolympiacompose.data.api.model.ClassicPhysique


@Composable
fun HomeSc() {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by homeViewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Participants and winners of Mr.Olympia",
            fontFamily = FontFamily.Serif,
            fontSize = 26.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn (modifier = Modifier.testTag(LIST_TEST_TAG)) {
            if (state.isEmpty()) {
                item {
                    CircularProgressIndicator(
                        color = Color.Blue,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }

            items(state) { classic: ClassicPhysique ->
                OlympiaImageCard(classicPhysique = classic)
            }

        }
    }
}

@Composable
fun OlympiaImageCard(classicPhysique: ClassicPhysique) {

    val imagerPainter = rememberAsyncImagePainter(model = classicPhysique.imageTa)

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp),
        elevation = 0.dp,
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Column {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //Name
                    Text(
                        text = "${classicPhysique.name}",
                        style = typography.h6,
                        textAlign = TextAlign.Center,
                        fontSize = 22.sp
                    )
                }
            }

            Image(
                painter = imagerPainter,
                contentDescription = "Olympia image",
                Modifier
                    .background(color = Color.Gray)
                    .fillMaxWidth()
                    .height(194.dp)
            )
            // Explain about Mr olympia
            Column {
                Text(
                    text = "His nationality is ${classicPhysique.nationality} \n",
                    overflow = TextOverflow.Ellipsis,
                    style = typography.body2,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 8.dp, bottom = 2.dp, top = 8.dp)
                )
                Text(
                    text = "Years he won a Mr Olympia: ${classicPhysique.winMisterOlympia}",
                    overflow = TextOverflow.Ellipsis,
                    style = typography.body2,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp, top = 2.dp)
                )
            }
        }
    }
}