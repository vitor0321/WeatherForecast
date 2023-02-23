package com.walcker.core.usecase.weather

import com.walcker.core.data.DataOrException
import com.walcker.core.data.repository.WeatherRemoteRepository
import com.walcker.core.model.WeatherResponseUI
import com.walcker.core.usecase.base.CoroutinesDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface GetWeatherByCity {

    suspend operator fun invoke(params: Params): DataOrException<WeatherResponseUI, Boolean, Exception>

    data class Params(val city: String, val units: String)
}

class GetWeatherByCityImpl @Inject constructor(
    private val weatherRepository: WeatherRemoteRepository,
    private val dispatchers: CoroutinesDispatchers
) : GetWeatherByCity {

    override suspend fun invoke(params: GetWeatherByCity.Params): DataOrException<WeatherResponseUI, Boolean, Exception> {
        return withContext(dispatchers.io()){
            weatherRepository.getWeatherByCity(cityQuery = params.city, unitQuery = params.units)
        }
    }
}