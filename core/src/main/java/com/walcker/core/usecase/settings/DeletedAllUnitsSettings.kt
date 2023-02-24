package com.walcker.core.usecase.settings

import com.walcker.core.data.repository.WeatherLocalRepository
import com.walcker.core.usecase.base.CoroutinesDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface DeleteAllUnitsSettings {

    suspend operator fun invoke()
}

class DeleteAllUnitsSettingsImpl @Inject constructor(
    private val weatherRepository: WeatherLocalRepository,
    private val dispatchers: CoroutinesDispatchers
) : DeleteAllUnitsSettings {

    override suspend fun invoke() {
        withContext(dispatchers.io()) {
            weatherRepository.deleteAllUnits()
        }
    }
}