package com.walcker.weatherforecast.network.remoteRepository.response

import androidx.room.ColumnInfo

data class Temp(
    @ColumnInfo(name = "day")
    val day: Double,
    @ColumnInfo(name = "eve")
    val eve: Double,
    @ColumnInfo(name = "max")
    val max: Double,
    @ColumnInfo(name = "min")
    val min: Double,
    @ColumnInfo(name = "morn")
    val morn: Double,
    @ColumnInfo(name = "night")
    val night: Double
)