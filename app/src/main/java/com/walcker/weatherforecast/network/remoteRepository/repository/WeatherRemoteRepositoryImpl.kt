package com.walcker.weatherforecast.network.remoteRepository.repository

import com.walcker.core.data.DataOrException
import com.walcker.core.data.repository.WeatherRemoteRepository
import com.walcker.core.model.WeatherResponseUI
import com.walcker.weatherforecast.network.remoteRepository.WeatherApi
import com.walcker.weatherforecast.network.remoteRepository.response.toWeatherResponseUI
import javax.inject.Inject


class WeatherRemoteRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
) : WeatherRemoteRepository {

    override suspend fun getWeatherByCity(cityQuery: String, unitsQuery: String): DataOrException<WeatherResponseUI, Boolean, Exception> {
        val response = try {
            weatherApi.getWeather(cityQuery, unitsQuery).toWeatherResponseUI()
        } catch (e: Exception) {
            return DataOrException(e = e)
        }
        return DataOrException(data = response)
    }
}