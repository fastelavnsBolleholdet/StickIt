package com.example.stickitapp.challenge

import TimerState
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf

class ChallengeViewModel: ViewModel() {

    fun moveToFrontPage(navigateFrontPage: () -> Unit) {

        navigateFrontPage()

    }

    val currentChallenge = mutableStateOf("")
    val timerState = TimerState()

    private val challenges = listOf(
        "Eat a bowl of popcorn one kernel at a time.",
        "Stack 5 sugar cubes.",
        "Transfer 10 M&M's from one bowl to another, one at a time.",
        "Draw a smiley face using chopsticks.",
        "Pick up a single grain of rice.",
        "Tie a knot in a cherry stem.",
        "Build a house of cards using chopsticks.",
        "Thread a needle with chopsticks.",
        "Create a tower with marshmallows and toothpicks.",
        "Balance an egg on a spoon held by chopsticks and walk 10 steps without dropping it.",
        "Use chopsticks to write your name in rice.",
        "Pick up as many jellybeans as possible in 30 seconds.",
        "Scoop a scoop of ice cream onto a cone using chopsticks."
    )

    fun generateRandomChallenge() {
        currentChallenge.value = challenges.random()
    }

    fun startTimer() {
        timerState.start()
    }

    fun stopTimer() {
        timerState.stop()
    }

    val isTimerRunning = mutableStateOf(false)

    fun toggleTimer() {
        isTimerRunning.value = !isTimerRunning.value
        if (isTimerRunning.value) {
            startTimer()
        } else {
            stopTimer()
        }
    }
}