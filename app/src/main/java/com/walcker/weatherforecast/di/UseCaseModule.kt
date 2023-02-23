package com.walcker.weatherforecast.di

import com.walcker.core.usecase.*
import com.walcker.core.usecase.favorite.*
import com.walcker.core.usecase.settings.*
import com.walcker.core.usecase.weather.GetWeatherByCity
import com.walcker.core.usecase.weather.GetWeatherByCityImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindDeleteAllFavoriteUseCase(useCase: DeleteAllFavoritesImpl): DeleteAllFavorites

    @Binds
    fun bindDeleteFavoriteUseCase(useCase: DeleteFavoritesImpl): DeleteFavorites

    @Binds
    fun bindGetFavoriteUseCase(useCase: GetFavoritesImpl): GetFavorites

    @Binds
    fun bindGetFavoriteByIdUseCase(useCase: GetFavoritesByIdImpl): GetFavoritesById

    @Binds
    fun bindGetWeatherByCityUseCase(useCase: GetWeatherByCityImpl): GetWeatherByCity

    @Binds
    fun bindInsertFavoriteUseCase(useCase: InsertFavoritesImpl): InsertFavorites

    @Binds
    fun bindUpdateFavoriteUseCase(useCase: UpdateFavoritesImpl): UpdateFavorites

    @Binds
    fun bindDeleteAllUnitsUseCase(useCase: DeleteAllUnitsSettingsImpl): DeleteAllUnitsSettings

    @Binds
    fun bindDeleteUnitUseCase(useCase: DeleteUnitSettingsImpl): DeleteUnitSettings

    @Binds
    fun bindGetUnitsUseCase(useCase: GetUnitsSettingsImpl): GetUnitsSettings

    @Binds
    fun bindInsertUnitsCase(useCase: InsertUnitsSettingsImpl): InsertUnitsSettings

    @Binds
    fun bindUpdateUnitCase(useCase: UpdateUnitSettingsImpl): UpdateUnitSettings
}