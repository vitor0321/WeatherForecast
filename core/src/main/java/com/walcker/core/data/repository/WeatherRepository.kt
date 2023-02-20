package com.walcker.core.data.repository

import com.walcker.core.data.DataOrException
import com.walcker.core.model.WeatherResponseUI

interface WeatherRepository {

    suspend fun getWeatherByCity(cityQuery: String): DataOrException<WeatherResponseUI, Boolean, Exception>
}