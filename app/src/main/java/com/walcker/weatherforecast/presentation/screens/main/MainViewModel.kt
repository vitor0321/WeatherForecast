package com.walcker.weatherforecast.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walcker.core.data.constants.UnitStateEnum
import com.walcker.core.model.UnitUI
import com.walcker.core.usecase.base.CoroutinesDispatchers
import com.walcker.core.usecase.settings.GetUnitsSettings
import com.walcker.core.usecase.weather.GetWeatherByCity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getWeatherByCity: GetWeatherByCity,
) : ViewModel() {

    suspend fun getWeather(city: String, units: String) = getWeatherByCity(GetWeatherByCity.Params(city = city, units = units))
}
