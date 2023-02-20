package com.walcker.weatherforecast.network.response

import androidx.room.ColumnInfo
import com.walcker.core.model.WeatherResponseUI

data class WeatherResponse(
    @ColumnInfo(name = "city")
    val city: City,
    @ColumnInfo(name = "cnt")
    val cnt: Int,
    @ColumnInfo(name = "cod")
    val cod: String,
    @ColumnInfo(name = "list")
    val list: List<WeatherItem>,
    @ColumnInfo(name = "message")
    val message: Double
)

fun WeatherResponse.toWeatherResponseUI(): WeatherResponseUI{
    return WeatherResponseUI(
        idCity = this.city.id,
        cnt = this.cnt,
        cod = this.cod,
        message = this.message,
        country = this.city.country,
        nameCity = this.city.name,
        population = this.city.population,
        timezone = this.city.timezone,
        latCity = this.city.coord.lat,
        lonCity = this.city.coord.lon,
        listWeatherItem = this.list.map { it.toWeatherItemUI() }
    )
}