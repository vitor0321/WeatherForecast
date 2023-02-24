package com.walcker.core.usecase.settings

import com.walcker.core.data.repository.WeatherLocalRepository
import com.walcker.core.model.UnitUI
import com.walcker.core.usecase.base.CoroutinesDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface DeleteUnitSettings {

    suspend operator fun invoke(params: Params)

    data class Params(val unitsUI: UnitUI)

}

class DeleteUnitSettingsImpl @Inject constructor(
    private val weatherRepository: WeatherLocalRepository,
    private val dispatchers: CoroutinesDispatchers
) : DeleteUnitSettings {

    override suspend fun invoke(params: DeleteUnitSettings.Params) {
        withContext(dispatchers.io()) {
            weatherRepository.deleteUnit(params.unitsUI)
        }
    }
}