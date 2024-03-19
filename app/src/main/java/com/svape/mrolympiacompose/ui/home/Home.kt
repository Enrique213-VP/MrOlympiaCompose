package com.svape.mrolympiacompose.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.svape.mrolympiacompose.FloatingActionButtons
import com.svape.mrolympiacompose.core.Constants.LIST_TEST_TAG
import com.svape.mrolympiacompose.data.api.model.ClassicPhysique
import com.svape.mrolympiacompose.ui.home.itemOlympia.PeopleListItem


@Composable
fun HomeSc(navigateToProfile: (ClassicPhysique) -> Unit) {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by homeViewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Mr Olympia and amazing people",
            fontFamily = FontFamily.Serif,
            fontSize = 26.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn(
            modifier = Modifier.testTag(LIST_TEST_TAG),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            if (state.isEmpty()) {
                item {
                    CircularProgressIndicator(
                        color = Color.White,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
            items(state) { classic: ClassicPhysique ->
                PeopleListItem(classicPhysique = classic, navigateToProfile)
            }
        }
    }
    if (state.isEmpty()) {
        //TODO
    } else {
        FloatingActionButtons()
    }
}
