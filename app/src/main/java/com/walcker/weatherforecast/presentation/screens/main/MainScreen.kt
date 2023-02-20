package com.walcker.weatherforecast.presentation.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.walcker.core.data.DataOrException
import com.walcker.core.model.WeatherResponseUI

@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel = hiltViewModel()) {

    val weatherData = produceState<DataOrException<WeatherResponseUI, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = viewModel.getWeather("São Paulo")
    }.value

    if (weatherData.loading == true) {
        MainLoadingScreen()
    } else if (weatherData.data != null) {
        MainDataScreen(weatherData.data!!, navController)
    } else {
        MainErrorScreen()
    }
}