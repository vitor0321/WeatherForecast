package com.walcker.weatherforecast.network.response

import androidx.room.ColumnInfo
import com.walcker.core.model.WeatherItemUI

data class WeatherItem(
    @ColumnInfo(name = "clouds")
    val clouds: Int,
    @ColumnInfo(name = "deg")
    val deg: Int,
    @ColumnInfo(name = "dt")
    val dt: Int,
    @ColumnInfo(name = "feels_like")
    val feels_like: FeelsLike,
    @ColumnInfo(name = "gust")
    val gust: Double,
    @ColumnInfo(name = "humidity")
    val humidity: Int,
    @ColumnInfo(name = "pop")
    val pop: Double,
    @ColumnInfo(name = "pressure")
    val pressure: Int,
    @ColumnInfo(name = "rain")
    val rain: Double,
    @ColumnInfo(name = "speed")
    val speed: Double,
    @ColumnInfo(name = "sunrise")
    val sunrise: Int,
    @ColumnInfo(name = "sunset")
    val sunset: Int,
    @ColumnInfo(name = "temp")
    val temp: Temp,
    @ColumnInfo(name = "weather")
    val weather: List<WeatherObject>
)

fun WeatherItem.toWeatherItemUI(): WeatherItemUI{
    return WeatherItemUI(
        clouds = this.clouds,
        deg = this.deg,
        dt = this.dt,
        gust = this.gust,
        humidity = this.humidity,
        pop = this.pop,
        pressure = this.pressure,
        rain = this.rain,
        speed = this.speed,
        sunrise = this.sunrise,
        sunset = this.sunset,
        day = this.feels_like.day,
        max = this.temp.max,
        min = this.temp.min,
        eve = this.temp.eve,
        morn = this.temp.morn,
        night = this.temp.night,
        weather = this.weather.map { it.toWeatherObjectUI() }
    )
}