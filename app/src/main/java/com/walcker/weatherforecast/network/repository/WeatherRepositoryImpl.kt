package com.walcker.weatherforecast.network.repository

import com.walcker.core.data.DataOrException
import com.walcker.core.data.repository.WeatherRepository
import com.walcker.core.model.WeatherResponseUI
import com.walcker.weatherforecast.network.WeatherApi
import com.walcker.weatherforecast.network.response.toWeatherResponseUI
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherByCity(cityQuery: String): DataOrException<WeatherResponseUI, Boolean, Exception> {
        val response = try {
            weatherApi.getWeather(cityQuery).toWeatherResponseUI()
        } catch (e: Exception) {
            return DataOrException(e = e)
        }
        return DataOrException(data = response)
    }
}