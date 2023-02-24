package com.walcker.core.usecase.settings

import com.walcker.core.data.repository.WeatherLocalRepository
import com.walcker.core.model.UnitUI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetUnitsSettings {

    operator fun invoke(): Flow<List<UnitUI>>
}

class GetUnitsSettingsImpl @Inject constructor(
    private val weatherRepository: WeatherLocalRepository
) : GetUnitsSettings {

    override fun invoke(): Flow<List<UnitUI>> {
        return weatherRepository.getUnits()
    }
}