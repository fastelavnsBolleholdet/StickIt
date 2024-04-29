package com.example.stickitapp.loadingScreen

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stickitapp.ui.theme.noodleBoxColor
import com.example.stickitapp.welcome.welcomeViewModel
import kotlinx.coroutines.delay

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun NoodleChopsticks(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth() // Fill the width of the screen
            .fillMaxHeight(), // Ensures the Box fills the available height
        contentAlignment = Alignment.Center // Center content at the bottom
    ) {
        AndroidView(
            modifier = modifier.fillMaxWidth(), // Fill the width of the screen
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true // Enable JavaScript
                    setInitialScale(100) // Set the initial scale to fill the width
                    settings.useWideViewPort = true // Ensure the content fits the width
                    settings.loadWithOverviewMode = true // Allows the WebView to fit content
                }
            },
            update = { webView ->
                // Load the GIF into the WebView from assets or a URL
                webView.loadUrl("https://i.pinimg.com/originals/10/61/7a/10617a1214f2053a3b137a87f49bef8c.gif") // Or a URL
            }
        )
    }
}
@Composable
fun LoadingScreen(navigateChallenge: () -> Unit) {
    val loadingScreenViewModel = viewModel<loadingScreenViewModel>()
    LaunchedEffect(Unit) {
        delay(5000) // 5-second delay
        loadingScreenViewModel.moveToChallenge(navigateChallenge) // Navigate to the next screen
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(0.dp, 0.dp, 0.dp, 0.dp)
            .background(color = noodleBoxColor)
            ) {
        NoodleChopsticks()
    }
}

@Preview
@Composable
fun LoadingPreview() {
    LoadingScreen(navigateChallenge = {})
}