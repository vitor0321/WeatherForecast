package com.walcker.core.usecase

import com.walcker.core.data.DataOrException
import com.walcker.core.data.repository.WeatherRepository
import com.walcker.core.model.WeatherResponseUI
import javax.inject.Inject

interface GetWeatherByCity {

    suspend operator fun invoke(params: String): DataOrException<WeatherResponseUI, Boolean, Exception>

}

class GetWeatherByCityImpl @Inject constructor(
    private val weatherRepository: WeatherRepository
) : GetWeatherByCity {

    override suspend fun invoke(params: String): DataOrException<WeatherResponseUI, Boolean, Exception> {
        return weatherRepository.getWeatherByCity(params)
    }
}