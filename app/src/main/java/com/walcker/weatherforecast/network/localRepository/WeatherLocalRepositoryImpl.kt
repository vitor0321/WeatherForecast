package com.walcker.weatherforecast.network.localRepository

import com.walcker.core.data.repository.WeatherLocalRepository
import com.walcker.core.model.FavoriteUI
import com.walcker.core.model.UnitUI
import com.walcker.weatherforecast.network.localRepository.database.WeatherDao
import com.walcker.weatherforecast.network.localRepository.database.entity.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeatherLocalRepositoryImpl @Inject constructor(
    private val weatherDao: WeatherDao
): WeatherLocalRepository {

    override fun getFavorites(): Flow<List<FavoriteUI>> {
        return weatherDao.getFavorites().map{ it.toListFavoriteUI() }
    }

    override suspend fun getFavoriteById(city: String): FavoriteUI {
        return weatherDao.getFavoriteById(city = city).toFavoriteUI()
    }

    override suspend fun insertFavorite(favoriteUI: FavoriteUI) {
        return weatherDao.insertFavorite(favoriteUI.toFavoriteEntity())
    }

    override suspend fun updateFavorite(favoriteUI: FavoriteUI) {
        weatherDao.updateFavorite(favoriteUI.toFavoriteEntity())
    }

    override suspend fun deleteAllFavorite() {
        weatherDao.deleteAllFavorite()
    }

    override suspend fun deleteFavorite(favoriteUI: FavoriteUI) {
        weatherDao.deleteFavorite(favoriteUI.toFavoriteEntity())
    }

    override fun getUnits(): Flow<List<UnitUI>> {
        return weatherDao.getUnits().map {it.toListUnitUI()}
    }

    override suspend fun insertUnit(unitUI: UnitUI) {
        weatherDao.insertUit(unitUI.toUnitEntity())
    }

    override suspend fun updateUnit(unitUI: UnitUI) {
        weatherDao.updateUnit(unitUI.toUnitEntity())
    }

    override suspend fun deleteAllUnits() {
        weatherDao.deleteAllUnits()
    }

    override suspend fun deleteUnit(unitUI: UnitUI) {
        weatherDao.deleteUnit(unitUI.toUnitEntity())
    }
}