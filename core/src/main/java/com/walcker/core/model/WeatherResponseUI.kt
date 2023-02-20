package com.walcker.core.model

data class WeatherResponseUI(
    val idCity: Int,
    val cnt: Int,
    val cod: String,
    val message: Double,
    val country: String,
    val nameCity: String,
    val population: Int,
    val timezone: Int,
    val latCity: Double,
    val lonCity: Double,
    val listWeatherItem: List<WeatherItemUI>
)