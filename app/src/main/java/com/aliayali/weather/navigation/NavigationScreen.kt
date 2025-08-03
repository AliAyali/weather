package com.aliayali.weather.navigation

sealed class NavigationScreen(val route: String) {
    object Home : NavigationScreen("home")
    object WeatherCitiesScreen : NavigationScreen("weatherCitiesScreen")
    object CityScreen : NavigationScreen("cityScreen")
}