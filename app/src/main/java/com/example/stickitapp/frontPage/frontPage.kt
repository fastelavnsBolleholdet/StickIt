package com.example.stickitapp.frontPage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FrontPage(navigateLoadingScreen: () -> Unit) {

    val frontPageViewModel = viewModel<frontPageViewModel>()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Welcome!",
            modifier = Modifier.padding(top = 50.dp)
        )
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "How would you like to stick it?")

        Button(
            onClick = { frontPageViewModel.moveToLoadingScreen(navigateLoadingScreen) },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Click here for a sticky challenge")
        }
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxSize().padding(100.dp)
    ) {
        Box {
            Text(
                text = "This app works by giving you a chopstick challenge for you to complete in a given timeframe. If you are lucky you will get a rating",
                textAlign = TextAlign.Center
            )
        }
    }
}




@Preview
@Composable
fun FrontPagePreview() {
    FrontPage(navigateLoadingScreen = {})
}