package com.walcker.weatherforecast.di

import com.walcker.core.data.repository.WeatherLocalRepository
import com.walcker.core.data.repository.WeatherRemoteRepository
import com.walcker.weatherforecast.network.localRepository.WeatherLocalRepositoryImpl
import com.walcker.weatherforecast.network.remoteRepository.repository.WeatherRemoteRepositoryImpl
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
    fun bindWeatherRemoteRepository(repository: WeatherRemoteRepositoryImpl): WeatherRemoteRepository

    @Singleton
    @Binds
    fun bindWeatherLocalRepository(repository: WeatherLocalRepositoryImpl): WeatherLocalRepository
}