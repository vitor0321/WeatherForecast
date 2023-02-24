package com.walcker.weatherforecast.network.remoteRepository.response

import androidx.room.ColumnInfo

data class Coord(
    @ColumnInfo(name = "lat")
    val lat: Double,
    @ColumnInfo(name = "lon")
    val lon: Double
)