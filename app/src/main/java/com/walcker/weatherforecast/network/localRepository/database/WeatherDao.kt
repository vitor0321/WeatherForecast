package com.walcker.weatherforecast.network.localRepository.database

import androidx.room.*
import com.walcker.core.data.constants.Constants.COLUMN_CITY
import com.walcker.core.data.constants.Constants.TABLE_NAME
import com.walcker.core.data.constants.Constants.TABLE_NAME_SETTINGS
import com.walcker.weatherforecast.network.localRepository.database.entity.FavoriteEntity
import com.walcker.weatherforecast.network.localRepository.database.entity.UnitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    // FAVORITE TABLE

    @Query(value = "SELECT * FROM $TABLE_NAME")
    fun getFavorites(): Flow<List<FavoriteEntity>>

    @Query(value = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_CITY =:city")
    suspend fun getFavoriteById(city: String): FavoriteEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favoriteEntity: FavoriteEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFavorite(favoriteEntity: FavoriteEntity)

    @Query(value = "DELETE FROM $TABLE_NAME")
    suspend fun deleteAllFavorite()

    @Delete
    suspend fun deleteFavorite(favoriteEntity: FavoriteEntity)

    // UNIT TABLE

    @Query(value = "SELECT * FROM $TABLE_NAME_SETTINGS")
    fun getUnits(): Flow<List<UnitEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUit(unitEntity: UnitEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUnit(unitEntity: UnitEntity)

    @Query(value = "DELETE FROM $TABLE_NAME_SETTINGS")
    suspend fun deleteAllUnits()

    @Delete
    suspend fun deleteUnit(unitEntity: UnitEntity)
}