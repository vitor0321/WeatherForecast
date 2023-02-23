package com.walcker.weatherforecast.network.remoteRepository

import com.walcker.weatherforecast.BuildConfig
import com.walcker.weatherforecast.network.remoteRepository.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {

    //https://api.openweathermap.org/data/2.5/forecast/daily?q=lisbon&appid=ed60fcfbd1eea&units=imperial
    @GET(value = "data/2.5/forecast/daily")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("units") units: String = "imperial",
        @Query("appid") appid: String = BuildConfig.PRIVATE_KEY
    ): WeatherResponse

}