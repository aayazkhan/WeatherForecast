package com.example.weatherforecast.screens.main

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.weatherforecast.data.DataOrException
import com.example.weatherforecast.model.Weather

@Composable
fun MainScreen(navController: NavHostController, mainViewModel: MainViewModel = hiltViewModel()) {

    showData(mainViewModel)

}

@Composable
fun showData(mainViewModel: MainViewModel) {
    val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = mainViewModel.getWeatherData(city = "Mumbai,India")
    }.value

    if (weatherData.loading == true) {
        CircularProgressIndicator()
    } else if (weatherData.data != null) {
        Text(text = "Main screen ${weatherData.data!!.city.country}")
    }

}
