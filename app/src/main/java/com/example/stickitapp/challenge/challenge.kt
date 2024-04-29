package com.example.stickitapp.challenge

import TimerState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun Challenge(navigateFrontPage: () -> Unit) {
    val challengeViewModel = viewModel<ChallengeViewModel>()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            modifier = Modifier
                .fillMaxHeight(0.15f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Your challenge is:"
            )
        }
        Row (
            modifier = Modifier
                .fillMaxHeight(0.15f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            // Display the current challenge text
            Text(
                text = challengeViewModel.currentChallenge.value,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row (
            modifier = Modifier
                .fillMaxHeight(0.25f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            // Button to generate a new random challenge
            Button(
                onClick = {
                    challengeViewModel.generateRandomChallenge()
                    if (challengeViewModel.isTimerRunning.value) {
                        challengeViewModel.startTimer()
                    }
                }
            ) {
                Text("Generate Random Challenge")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row (
            modifier = Modifier
                .fillMaxHeight(0.25f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            // Display the timer
            Timer(challengeViewModel.timerState)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row (
            modifier = Modifier
                .fillMaxHeight(0.25f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                onClick = { challengeViewModel.toggleTimer() }
            ) {
                Text(if (challengeViewModel.isTimerRunning.value) "Stop Timer" else "Start Timer")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row (
            modifier = Modifier
                .fillMaxHeight(0.25f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            // Button to navigate back to the front page
            Button(onClick = { challengeViewModel.moveToFrontPage(navigateFrontPage) }) {
                Text("Back to Front Page")
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
        style = TextStyle(fontWeight = FontWeight.Bold)
    )
}

// Preview composable
@Preview
@Composable
fun ChallengePreview() {
    Challenge(navigateFrontPage = {})
}
