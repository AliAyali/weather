package com.aliayali.weather.data.remote.repository

import com.aliayali.weather.data.remote.api.WeatherApiService
import com.aliayali.weather.data.remote.model.CurrentWeatherResponse
import jakarta.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: WeatherApiService,
) {
    suspend fun getCurrentWeather(city: String, apiKey: String): CurrentWeatherResponse? {
        val response = api.getCurrentWeather(city, apiKey)
        return if (response.isSuccessful) response.body() else null
    }
}