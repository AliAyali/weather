package com.aliayali.weather.navigation

sealed class NavigationScreen(val route: String) {
    object Home : NavigationScreen("home")
}