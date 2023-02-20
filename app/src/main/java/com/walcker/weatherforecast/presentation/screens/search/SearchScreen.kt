package com.walcker.weatherforecast.presentation.screens.search

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun SearchScreen(navController: NavHostController, viewModel: SearchViewModel = hiltViewModel()) {

    Text("WeatherSplashScreen")
}