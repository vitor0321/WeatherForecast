package com.walcker.weatherforecast.presentation.screens.main

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.walcker.core.data.DataOrException
import com.walcker.core.data.constants.UnitStateEnum
import com.walcker.core.model.WeatherResponseUI
import com.walcker.weatherforecast.presentation.screens.main.error.MainErrorScreen
import com.walcker.weatherforecast.presentation.screens.main.loading.MainLoadingScreen
import com.walcker.weatherforecast.presentation.screens.main.success.MainSuccessScreen
import com.walcker.weatherforecast.presentation.screens.settings.SettingsViewModel

@Composable
fun MainScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel(),
    settingsViewModel: SettingsViewModel = hiltViewModel(),
    cityName: String?
) {

    val unitFromDB = settingsViewModel.unitList.collectAsState().value
    val unit = remember { mutableStateOf("") }
    val isImperial = remember { mutableStateOf(false) }

    if (unitFromDB.isNotEmpty()) {

        unit.value = unitFromDB.lowercase()
        isImperial.value = unit.value == UnitStateEnum.IMPERIAL.value.lowercase()

        val weatherData = produceState<DataOrException<WeatherResponseUI, Boolean, Exception>>(
            initialValue = DataOrException(loading = true)
        ) {
            cityName?.let {
                value = mainViewModel.getWeather(city = it, units = unit.value)
            }
        }.value

        if (weatherData.loading == true) {
            MainLoadingScreen()
        } else if (weatherData.data != null) {
            MainSuccessScreen(
                weatherResponseUI = weatherData.data!!,
                navController =  navController,
                isImperial = isImperial)
        } else {
            MainErrorScreen(
                navController = navController,
                exception = weatherData.e)
        }
    }
}
