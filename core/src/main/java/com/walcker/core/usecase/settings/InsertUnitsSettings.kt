package com.walcker.core.usecase.settings

import com.walcker.core.data.repository.WeatherLocalRepository
import com.walcker.core.model.UnitUI
import com.walcker.core.usecase.base.CoroutinesDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface InsertUnitsSettings {

    suspend operator fun invoke(params: Params)

    data class Params(val unitUI: UnitUI)
}

class InsertUnitsSettingsImpl @Inject constructor(
    private val weatherRepository: WeatherLocalRepository,
    private val dispatchers: CoroutinesDispatchers
) : InsertUnitsSettings {

    override suspend fun invoke(params: InsertUnitsSettings.Params) {
        withContext(dispatchers.io()) {
            weatherRepository.insertUnit(params.unitUI)
        }
    }
}