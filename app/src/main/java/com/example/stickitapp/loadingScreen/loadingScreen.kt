package com.example.stickitapp.loadingScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoadingScreen(navigateChallenge: () -> Unit) {

    val loadingScreenViewModel = viewModel<loadingScreenViewModel>()

}

@Preview
@Composable
fun LoadingPreview() {
    LoadingScreen(navigateChallenge = {})
}