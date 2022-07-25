package com.example.weatherforecast.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherforecast.screens.main.MainScreen
import com.example.weatherforecast.screens.main.MainViewModel
import com.example.weatherforecast.screens.splash.WeatherSplashScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.name
    ){
        composable(AppScreens.SplashScreen.name) {
            WeatherSplashScreen(navController = navController)
        }
        composable(AppScreens.MainScreen.name) {
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(navController = navController, mainViewModel)
        }
    }
}