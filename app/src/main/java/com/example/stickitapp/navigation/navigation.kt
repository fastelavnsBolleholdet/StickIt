package com.example.stickitapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stickitapp.challenge.Challenge
import com.example.stickitapp.frontPage.FrontPage
import com.example.stickitapp.loadingScreen.LoadingScreen
import com.example.stickitapp.welcome.Welcome

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome"){
            Welcome(navigateFrontPage = { navController.navigate("frontPage") })
        }/*
        composable("frontPage"){
            FrontPage(navigateLoadingScreen = { navController.navigate("loadingScreen") })
        }*/
        composable("loadingScreen"){
            LoadingScreen(navigateChallenge = { navController.navigate("challenge") })
        }
        composable("FrontPage"){
            Challenge(navigateFrontPage = { navController.navigate("frontPage") })
        }
    }
}