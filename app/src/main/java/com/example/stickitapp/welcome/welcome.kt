package com.example.stickitapp.welcome

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Welcome(navigateFrontPage: () -> Unit) {

    val welcomeViewModel = viewModel<welcomeViewModel>()

    
}

@Preview
@Composable
fun WelcomePreview() {
    Welcome(navigateFrontPage = {})
}