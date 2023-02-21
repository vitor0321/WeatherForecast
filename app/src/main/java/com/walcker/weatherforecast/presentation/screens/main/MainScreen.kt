package com.walcker.weatherforecast.presentation.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.walcker.core.data.DataOrException
import com.walcker.core.model.WeatherResponseUI
import com.walcker.weatherforecast.presentation.screens.main.error.MainErrorScreen
import com.walcker.weatherforecast.presentation.screens.main.loading.MainLoadingScreen
import com.walcker.weatherforecast.presentation.screens.main.success.MainSuccessScreen

@Composable
fun MainScreen(
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel(),
    cityName: String?
) {

    val weatherData = produceState<DataOrException<WeatherResponseUI, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        cityName?.let {
            value = viewModel.getWeather(it)
        }
    }.value

    if (weatherData.loading == true) {
        MainLoadingScreen()
    } else if (weatherData.data != null) {
        MainSuccessScreen(weatherData.data!!, navController)
    } else {
        MainErrorScreen(navController = navController, exception = weatherData.e)
    }
}
