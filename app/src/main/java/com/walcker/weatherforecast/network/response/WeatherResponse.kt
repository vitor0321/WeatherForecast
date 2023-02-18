package com.walcker.weatherforecast.network.response

data class WeatherResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<WeatherItem>,
    val message: Double
)