package com.aliayali.weather.data.remote.model

data class CurrentWeatherResponse(
    val weather: List<WeatherDescription>,
    val main: Main,
    val name: String,
)

data class WeatherDescription(
    val description: String,
    val icon: String,
)

data class Main(
    val temp: Double,
    val temp_min: Double,
    val temp_max: Double,
)

