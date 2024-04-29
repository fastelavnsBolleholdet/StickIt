package com.example.stickitapp.challenge

import TimerState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stickitapp.ui.theme.Dusty
import com.example.stickitapp.ui.theme.Typography
import com.example.stickitapp.ui.theme.ash
import com.example.stickitapp.ui.theme.burger
import com.example.stickitapp.ui.theme.jaldiBoldFontFamily
import com.example.stickitapp.ui.theme.salmon
import com.example.stickitapp.ui.theme.yellowy


@Composable
fun Challenge(navigateFrontPage: () -> Unit) {
    val challengeViewModel = viewModel<ChallengeViewModel>()

    Box(
        Modifier.background(color = burger)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight(0.15f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Your challenge is:",
                    fontFamily = jaldiBoldFontFamily,
                    style = Typography.labelSmall,
                    fontSize = 50.sp,
                    color = salmon
                )
            }
            Row(
                modifier = Modifier.padding(start = 25.dp, end = 25.dp)
                    .fillMaxHeight(0.15f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                // Display the current challenge text
                Text(
                    text = challengeViewModel.currentChallenge.value,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    fontFamily = jaldiBoldFontFamily,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    color = ash
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxHeight(0.2f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                // Button to generate a new random challenge
                Button(
                    onClick = {
                        challengeViewModel.generateRandomChallenge()
                        if (challengeViewModel.isTimerRunning.value) {
                            challengeViewModel.startTimer()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        Dusty
                    )
                ) {
                    Text(
                        "Generate Random Challenge",
                        fontFamily = jaldiBoldFontFamily,
                        style = Typography.labelSmall,
                        fontSize = 20.sp,
                        color = salmon
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxHeight(0.25f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                // Display the timer
                Timer(challengeViewModel.timerState)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxHeight(0.25f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { challengeViewModel.toggleTimer() },
                    colors = ButtonDefaults.buttonColors(
                        Dusty
                    )
                ) {
                    Text(
                        if (challengeViewModel.isTimerRunning.value) "Stop Timer" else "Start Timer",
                        fontFamily = jaldiBoldFontFamily,
                        style = Typography.labelSmall,
                        fontSize = 20.sp,
                        color = salmon
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxHeight(0.25f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                // Button to navigate back to the front page
                Button(
                    onClick = { challengeViewModel.moveToFrontPage(navigateFrontPage) },
                    colors = ButtonDefaults.buttonColors(
                        Dusty
                    )
                ) {
                    Text(
                        "Back to Front Page",
                        fontFamily = jaldiBoldFontFamily,
                        style = Typography.labelSmall,
                        fontSize = 20.sp,
                        color = salmon
                    )
                }
            }
        }
    }
}

@Composable
fun Timer(timerState: TimerState) {
    val elapsedTime = timerState.elapsedTime

    // Convert elapsed time to minutes and seconds
    val minutes = elapsedTime / 60000
    val seconds = (elapsedTime / 1000) % 60

    // Display the timer
    Text(
        text = "Time: $minutes:${String.format("%02d", seconds)}",
        style = TextStyle(fontWeight = FontWeight.Bold),
        fontFamily = jaldiBoldFontFamily,
        fontSize = 30.sp,
        color = ash
    )
}

// Preview composable
@Preview
@Composable
fun ChallengePreview() {
    Challenge(navigateFrontPage = {})
}
