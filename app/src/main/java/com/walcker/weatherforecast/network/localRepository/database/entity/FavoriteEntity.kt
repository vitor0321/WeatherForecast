package com.walcker.weatherforecast.network.localRepository.database.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.walcker.core.data.constants.Constants.COLUMN_CITY
import com.walcker.core.data.constants.Constants.COLUMN_COUNTRY
import com.walcker.core.data.constants.Constants.TABLE_NAME
import com.walcker.core.model.FavoriteUI

@Entity(tableName = TABLE_NAME)
data class FavoriteEntity(
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = COLUMN_CITY)
    val city: String,
    @ColumnInfo(name = COLUMN_COUNTRY)
    val country: String
)

fun FavoriteEntity.toFavoriteUI(): FavoriteUI {
    return FavoriteUI(
        city = this.city,
        country = this.country
    )
}

fun List<FavoriteEntity>.toListFavoriteUI(): List<FavoriteUI> = this.map {
    FavoriteUI(
        city = it.city,
        country = it.country
    )
}

fun FavoriteUI.toFavoriteEntity(): FavoriteEntity {
    return FavoriteEntity(
        city = this.city,
        country = this.country
    )
}
