package com.svape.mrolympiacompose.ui.network

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.svape.mrolympiacompose.R

@Composable
fun UnavailableScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.wifi_off),
            contentDescription = "Unavailable wifi",
            modifier = Modifier.size(100.dp),
            colorFilter = ColorFilter.tint(androidx.compose.ui.graphics.Color.White)
        )

        Spacer(modifier = Modifier.height(20.dp))
        
        Text(text = "Necesitas una conexión a internet", fontSize = 18.sp)
    }
}