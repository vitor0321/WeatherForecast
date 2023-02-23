package com.walcker.weatherforecast.network.localRepository.database.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.walcker.core.data.constants.Constants.COLUMN_UNIT
import com.walcker.core.data.constants.Constants.TABLE_NAME_SETTINGS
import com.walcker.core.model.FavoriteUI
import com.walcker.core.model.UnitUI

@Entity(tableName = TABLE_NAME_SETTINGS)
data class UnitEntity(
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = COLUMN_UNIT)
    val unit: String
)

fun UnitEntity.toUnitUI(): UnitUI {
    return UnitUI(
        unit = this.unit
    )
}

fun List<UnitEntity>.toListUnitUI(): List<UnitUI> = this.map {
    UnitUI(
        unit = it.unit
    )
}

fun UnitUI.toUnitEntity(): UnitEntity {
    return UnitEntity(
        unit = this.unit
    )
}
