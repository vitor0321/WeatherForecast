package com.walcker.weatherforecast.network.localRepository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.walcker.weatherforecast.network.localRepository.database.entity.FavoriteEntity
import com.walcker.weatherforecast.network.localRepository.database.entity.UnitEntity

@Database(entities = [FavoriteEntity::class, UnitEntity::class], version = 2, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase(){

    abstract fun weatherDao(): WeatherDao

}