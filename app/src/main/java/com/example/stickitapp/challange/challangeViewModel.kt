package com.example.stickitapp.challange

import androidx.lifecycle.ViewModel

class challengeViewModel: ViewModel() {

    fun moveToLoadingScreen(navigateFrontPage: () -> Unit) {

        navigateFrontPage()

    }
}