package com.walcker.weatherforecast.presentation.screens.main

import androidx.lifecycle.ViewModel
import com.walcker.core.usecase.GetWeatherByCity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getWeatherByCity: GetWeatherByCity,
) : ViewModel() {

    suspend fun getWeather(city: String) = getWeatherByCity(GetWeatherByCity.Params(city = city))

}
