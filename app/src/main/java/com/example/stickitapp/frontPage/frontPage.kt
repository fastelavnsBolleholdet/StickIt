package com.example.stickitapp.frontPage

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stickitapp.ui.theme.Dusty
import com.example.stickitapp.ui.theme.Typography
import com.example.stickitapp.ui.theme.ash
import com.example.stickitapp.ui.theme.blue
import com.example.stickitapp.ui.theme.burger
import com.example.stickitapp.ui.theme.green
import com.example.stickitapp.ui.theme.jaldiBoldFontFamily
import com.example.stickitapp.ui.theme.jaldiFontFamily
import com.example.stickitapp.ui.theme.katibehFontFamily
import com.example.stickitapp.ui.theme.playFairDisplayFontFamily
import com.example.stickitapp.ui.theme.salmon
import com.example.stickitapp.ui.theme.yellowy

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun FrontPageGIF(modifier: Modifier = Modifier) {
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
                webView.loadUrl("https://media.tenor.com/z5DCfb9BcwwAAAAi/catching-fly-using-chopstick-miyagi.gif") // Or a URL
            }
        )
    }
}
@Composable
fun FrontPage(navigateLoadingScreen: () -> Unit) {

    val frontPageViewModel = viewModel<frontPageViewModel>()


    Column (modifier = Modifier
        .background(color = burger)
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Row {
            Box(
                modifier = Modifier
                    .background(color = burger)
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "How would you like to stick it?",
                    fontSize = 28.sp,
                    color = salmon,
                    fontFamily = jaldiBoldFontFamily,
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Prove your chopstick skills.",
                    Modifier.padding(bottom = 10.dp),
                    fontFamily = jaldiBoldFontFamily,
                    fontSize = 22.sp
                )

                Text(
                    text = "Complete a chopstick challenge within the timeframe.",
                    textAlign = TextAlign.Center,
                    fontFamily = jaldiBoldFontFamily,
                    fontSize = 22.sp
                )

                Text(
                    text = "If you are lucky you will get a rating",
                    Modifier.padding(bottom = 10.dp),
                    fontFamily = jaldiBoldFontFamily,
                    fontSize = 20.sp
                )
            }
        }
        Row{
            Box(
                modifier = Modifier
                    .background(color = burger)
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f),
                contentAlignment = Alignment.BottomCenter
            ) {
                Button(
                    onClick = { frontPageViewModel.moveToLoadingScreen(navigateLoadingScreen) },
                    modifier = Modifier
                        .padding(top = 16.dp),
                    colors = ButtonDefaults.buttonColors(Dusty)
                ) {
                    Text(
                        text = "Click here for a sticky challenge",
                        fontFamily = jaldiBoldFontFamily,
                        style = Typography.labelSmall,
                        fontSize = 22.sp,
                        color = salmon
                    )
                }
            }
        }
        FrontPageGIF()
    }
}




@Preview
@Composable
fun FrontPagePreview() {
    FrontPage(navigateLoadingScreen = {})
}