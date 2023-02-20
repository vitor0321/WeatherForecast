package com.walcker.weatherforecast.network.response

import androidx.room.ColumnInfo
import com.walcker.core.model.WeatherObjectUI

data class WeatherObject(
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "icon")
    val icon: String,
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "main")
    val main: String
)

fun WeatherObject.toWeatherObjectUI(): WeatherObjectUI {
    return WeatherObjectUI(
        id = this.id,
        description = this.description,
        icon = this.icon,
        main = this.main
    )
}