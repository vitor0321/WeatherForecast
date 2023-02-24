package com.walcker.core.data.repository

import com.walcker.core.model.FavoriteUI
import com.walcker.core.model.UnitUI
import kotlinx.coroutines.flow.Flow

interface WeatherLocalRepository {

    fun getFavorites(): Flow<List<FavoriteUI>>

    suspend fun getFavoriteById(city: String): FavoriteUI

    suspend fun insertFavorite(favoriteUI: FavoriteUI)

    suspend fun updateFavorite(favoriteUI: FavoriteUI)

    suspend fun deleteAllFavorite()

    suspend fun deleteFavorite(favoriteUI: FavoriteUI)

    fun getUnits(): Flow<List<UnitUI>>

    suspend fun insertUnit(unitUI: UnitUI)

    suspend fun updateUnit(unitUI: UnitUI)

    suspend fun deleteAllUnits()

    suspend fun deleteUnit(unitUI: UnitUI)
}