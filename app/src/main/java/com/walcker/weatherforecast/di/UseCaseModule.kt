package com.walcker.weatherforecast.di

import com.walcker.core.usecase.GetWeatherByCity
import com.walcker.core.usecase.GetWeatherByCityImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetWeatherByCityUseCase(useCase: GetWeatherByCityImpl): GetWeatherByCity
}