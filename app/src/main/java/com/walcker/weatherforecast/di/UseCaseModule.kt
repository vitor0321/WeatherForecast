package com.walcker.weatherforecast.di

import com.walcker.core.usecase.*
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
}