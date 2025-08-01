package com.aliayali.weather.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aliayali.weather.presenter.screen.home.HomeScreen

@Composable
fun SetupNavigation(
    padding: PaddingValues,
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = NavigationScreen.Home.route,
        modifier = Modifier.padding(padding)
    ) {

        composable(
            route = NavigationScreen.Home.route
        ) {
            HomeScreen(navController)
        }

    }

}
