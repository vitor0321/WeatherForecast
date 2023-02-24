package com.walcker.core.data.repository

import com.walcker.core.data.DataOrException
import com.walcker.core.model.WeatherResponseUI

interface WeatherRemoteRepository {

    suspend fun getWeatherByCity(cityQuery: String, unitQuery: String): DataOrException<WeatherResponseUI, Boolean, Exception>
}