package com.example.stickitapp.challange

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Challenge(navigateFrontPage: () -> Unit) {

    val challengeViewModel = viewModel<challengeViewModel>()

}

@Preview
@Composable
fun ChallengePreview() {
    Challenge(navigateFrontPage = {})
}