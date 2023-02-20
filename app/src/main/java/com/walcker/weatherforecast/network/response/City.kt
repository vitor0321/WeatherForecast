package com.walcker.weatherforecast.network.response

import androidx.room.ColumnInfo

data class City(
    @ColumnInfo(name = "coord")
    val coord: Coord,
    @ColumnInfo(name = "country")
    val country: String,
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "population")
    val population: Int,
    @ColumnInfo(name = "timezone")
    val timezone: Int
)