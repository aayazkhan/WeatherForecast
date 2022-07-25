package com.example.weatherforecast.network

import com.example.weatherforecast.model.Weather
import com.example.weatherforecast.model.WeatherObject
import com.example.weatherforecast.utils.Constant
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface API {

    @GET(value = "data/2.5/weather")
    suspend fun getWeather(
        @Query("q") q: String,
        @Query("units") units: String = "imperial",
        @Query("appid") appid: String = Constant.API_KEY
    ): Weather
}