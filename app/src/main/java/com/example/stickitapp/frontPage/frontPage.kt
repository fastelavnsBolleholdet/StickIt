package com.example.stickitapp.frontPage

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FrontPage(navigateLoadingScreen: () -> Unit) {

    val frontPageViewModel = viewModel<frontPageViewModel>()

}


@Preview
@Composable
fun FrontPagePreview() {
    FrontPage(navigateLoadingScreen = {})
}