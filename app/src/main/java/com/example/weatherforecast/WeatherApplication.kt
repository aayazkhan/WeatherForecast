package com.example.weatherforecast

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}