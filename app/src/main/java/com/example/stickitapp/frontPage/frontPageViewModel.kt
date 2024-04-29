package com.example.stickitapp.frontPage

import androidx.lifecycle.ViewModel

class frontPageViewModel: ViewModel() {


    fun moveToLoadingScreen(navigateLoadingScreen: () -> Unit) {

        navigateLoadingScreen()

    }

}