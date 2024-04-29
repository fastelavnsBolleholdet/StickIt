package com.example.stickitapp.challange

import androidx.lifecycle.ViewModel

class challengeViewModel: ViewModel() {

    fun moveToFrontPage(navigateFrontPage: () -> Unit) {

        navigateFrontPage()

    }
}