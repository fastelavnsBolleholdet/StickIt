package com.example.stickitapp.welcome

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stickitapp.R
import com.example.stickitapp.ui.theme.Dusty
import com.example.stickitapp.ui.theme.Typography
import com.example.stickitapp.ui.theme.green
import com.example.stickitapp.ui.theme.jaldiBoldFontFamily
import com.example.stickitapp.ui.theme.jaldiFontFamily
import com.example.stickitapp.ui.theme.karantinaFontFamily
import com.example.stickitapp.ui.theme.katibehFontFamily
import com.example.stickitapp.ui.theme.playFairDisplayFontFamily
import androidx.compose.foundation.clickable
import android.webkit.WebView
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.input.nestedscroll.nestedScrollModifierNode
import androidx.compose.ui.viewinterop.AndroidView
import com.example.stickitapp.ui.theme.burger
import com.example.stickitapp.ui.theme.salmon

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun ShowGifWithWebView(modifier: Modifier = Modifier) {
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
                webView.loadUrl("https://i.pinimg.com/originals/c8/b0/6d/c8b06d083b1a0f499f2afecb654bbb9f.gif") // Or a URL
            }, // Optional: Adjust the modifier as needed
        )
    }
}

@Composable
fun Welcome(navigateFrontPage: () -> Unit) {

    val welcomeViewModel = viewModel<welcomeViewModel>()
    Column(modifier = Modifier
        .background(color = burger)
        .clickable(onClick = {
            welcomeViewModel.moveToFrontPage(
                navigateFrontPage
            )
        }
        )
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Row {
            Box(modifier = Modifier
                .background(color = burger)
                .fillMaxWidth()
                .fillMaxHeight(0.4f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Stick It !",
                    fontFamily = jaldiBoldFontFamily,
                    style = Typography.labelSmall,
                    fontSize = 70.sp,
                    color = salmon)
            }
        }
        Row {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(0.dp, 0.dp, 0.dp, 200.dp)
                    .clickable(onClick = {
                        welcomeViewModel.moveToFrontPage(
                            navigateFrontPage
                        )
                    }
                    )) {
                ShowGifWithWebView()
            }
        }
    }
}

@Preview
@Composable
fun WelcomePreview() {
    Welcome(navigateFrontPage = {})
}