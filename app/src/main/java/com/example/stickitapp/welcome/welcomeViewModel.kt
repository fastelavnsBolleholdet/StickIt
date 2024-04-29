package com.example.stickitapp.welcome

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel

class welcomeViewModel: ViewModel() {

    fun moveToFrontPage(navigateFrontPage: () -> Unit) {

        navigateFrontPage()

    }

}