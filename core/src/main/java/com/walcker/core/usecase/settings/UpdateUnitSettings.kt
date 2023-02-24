package com.walcker.core.usecase.settings

import com.walcker.core.data.repository.WeatherLocalRepository
import com.walcker.core.model.UnitUI
import com.walcker.core.usecase.base.CoroutinesDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface UpdateUnitSettings {

    suspend operator fun invoke(params: Params)

    data class Params(val unitUI: UnitUI)
}

class UpdateUnitSettingsImpl @Inject constructor(
    private val weatherRepository: WeatherLocalRepository,
    private val dispatchers: CoroutinesDispatchers
) : UpdateUnitSettings {

    override suspend fun invoke(params: UpdateUnitSettings.Params) {
        withContext(dispatchers.io()) {
            weatherRepository.updateUnit(params.unitUI)
        }
    }
}