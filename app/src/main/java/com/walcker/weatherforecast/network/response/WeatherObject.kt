package com.walcker.weatherforecast.network.response

data class WeatherObject(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)