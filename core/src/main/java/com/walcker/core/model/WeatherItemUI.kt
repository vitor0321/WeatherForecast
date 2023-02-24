package com.walcker.core.model


data class WeatherItemUI(
    val clouds: Int,
    val deg: Int,
    val dt: Int,
    val gust: Double,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Double,
    val speed: Double,
    val sunrise: Int,
    val sunset: Int,
    val day: Double,
    val max: Double,
    val min: Double,
    val eve: Double,
    val morn: Double,
    val night: Double,
    val weather: List<WeatherObjectUI>
)