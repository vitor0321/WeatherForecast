package com.walcker.weatherforecast.di

import com.walcker.core.data.repository.WeatherRepository
import com.walcker.weatherforecast.network.repository.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface WeatherRepositoryModule {

    @Singleton
    @Binds
    fun bindWeatherRepository(repository: WeatherRepositoryImpl): WeatherRepository
}