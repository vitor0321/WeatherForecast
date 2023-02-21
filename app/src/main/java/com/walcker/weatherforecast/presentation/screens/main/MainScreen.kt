package com.walcker.weatherforecast.presentation.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.walcker.core.data.DataOrException
import com.walcker.core.model.WeatherResponseUI
import com.walcker.weatherforecast.presentation.screens.main.error.MainErrorScreen
import com.walcker.weatherforecast.presentation.screens.main.loading.MainLoadingScreen
import com.walcker.weatherforecast.presentation.screens.main.success.MainSuccessScreen

@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel = hiltViewModel()) {

    val weatherData = produceState<DataOrException<WeatherResponseUI, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = viewModel.getWeather("Maputo")
    }.value

    if (weatherData.loading == true) {
        MainLoadingScreen()
    } else if (weatherData.data != null) {
        MainSuccessScreen(weatherData.data!!, navController)
    } else {
        MainErrorScreen()
    }
}