package com.walcker.weatherforecast.di

import android.content.Context
import androidx.room.Room
import com.walcker.core.data.constants.Constants.DATABASE_NAME
import com.walcker.weatherforecast.network.localRepository.database.WeatherDatabase
import com.walcker.weatherforecast.network.localRepository.database.WeatherDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModulo {

    @Provides
    @Singleton
    fun provideWeatherDao(weatherDatabase: WeatherDatabase): WeatherDao = weatherDatabase.weatherDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): WeatherDatabase = Room
        .databaseBuilder(
            context = context,
            klass = WeatherDatabase::class.java,
            name = DATABASE_NAME
        )
        .fallbackToDestructiveMigration()
        .build()
}