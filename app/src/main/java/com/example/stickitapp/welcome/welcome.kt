package com.example.stickitapp.welcome

import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stickitapp.ui.theme.Dusty
import com.example.stickitapp.ui.theme.Typography
import com.example.stickitapp.ui.theme.green
import com.example.stickitapp.ui.theme.jaldiBoldFontFamily
import com.example.stickitapp.ui.theme.jaldiFontFamily
import com.example.stickitapp.ui.theme.karantinaFontFamily
import com.example.stickitapp.ui.theme.katibehFontFamily
import com.example.stickitapp.ui.theme.playFairDisplayFontFamily

@Composable
fun Welcome(navigateFrontPage: () -> Unit) {

    val welcomeViewModel = viewModel<welcomeViewModel>()

    Column(modifier = Modifier
        .background(color = Dusty)
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Row {
            Box(modifier = Modifier
                .background(color = Dusty)
                .fillMaxWidth()
                .fillMaxHeight(0.4f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Stick It !",
                    fontFamily = jaldiBoldFontFamily,
                    style = Typography.labelSmall,
                    fontSize = 50.sp,
                    color = green)
            }
        }
        Row {
            Box(modifier = Modifier) {
                Button(onClick = { navigateFrontPage()}) {
                }
            }
        }
    }
}

@Preview
@Composable
fun WelcomePreview() {
    Welcome(navigateFrontPage = {})
}