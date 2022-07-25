package com.example.weatherforecast.repository

import com.example.weatherforecast.data.DataOrException
import com.example.weatherforecast.model.Weather
import com.example.weatherforecast.model.WeatherObject
import com.example.weatherforecast.network.API
import javax.inject.Inject

class Repository @Inject constructor(private val api: API) {

    suspend fun getWeather(cityQuery: String): DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather(q = cityQuery)

        } catch (e: Exception) {
            return DataOrException(e = e)
        }
        return DataOrException(data = response)
    }

}