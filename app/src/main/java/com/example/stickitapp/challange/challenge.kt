package com.example.stickitapp.challange

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Challenge(navigateFrontPage: () -> Unit) {

    val challengeViewModel = viewModel<challengeViewModel>()
    Button(onClick = { challengeViewModel.moveToFrontPage(navigateFrontPage) }) {
        
    }
}

@Preview
@Composable
fun ChallengePreview() {
    Challenge(navigateFrontPage = {})
}