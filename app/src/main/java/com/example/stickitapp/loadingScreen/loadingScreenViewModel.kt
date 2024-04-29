package com.example.stickitapp.loadingScreen

import androidx.lifecycle.ViewModel

class loadingScreenViewModel: ViewModel() {

    fun moveToChallenge(navigateChallenge: () -> Unit) {

        navigateChallenge()

    }

}