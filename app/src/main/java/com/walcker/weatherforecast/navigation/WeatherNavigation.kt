package com.walcker.weatherforecast.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.walcker.weatherforecast.presentation.screens.about.AboutScreen
import com.walcker.weatherforecast.presentation.screens.favorite.FavoriteScreen
import com.walcker.weatherforecast.presentation.screens.main.MainScreen
import com.walcker.weatherforecast.presentation.screens.search.SearchScreen
import com.walcker.weatherforecast.presentation.screens.settings.SettingsScreen
import com.walcker.weatherforecast.presentation.screens.splash.SplashScreen

@Composable
fun WeatherNavigation() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = WeatherScreens.SplashScreen.name
    ) {
        composable(WeatherScreens.AboutScreen.name) {
            AboutScreen(navController = navController)
        }
        composable(WeatherScreens.FavoriteScreen.name) {
            FavoriteScreen(navController = navController)
        }
        composable(WeatherScreens.MainScreen.name) {
            MainScreen(navController = navController)
        }
        composable(WeatherScreens.SearchScreen.name) {
            SearchScreen(navController = navController)
        }
        composable(WeatherScreens.SettingsScreen.name) {
            SettingsScreen(navController = navController)
        }
        composable(WeatherScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
    }
}
