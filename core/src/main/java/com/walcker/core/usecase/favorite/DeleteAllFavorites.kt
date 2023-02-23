package com.walcker.core.usecase.favorite

import com.walcker.core.data.repository.WeatherLocalRepository
import com.walcker.core.usecase.base.CoroutinesDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface DeleteAllFavorites {

    suspend operator fun invoke()
}

class DeleteAllFavoritesImpl @Inject constructor(
    private val weatherRepository: WeatherLocalRepository,
    private val dispatchers: CoroutinesDispatchers
) : DeleteAllFavorites {

    override suspend fun invoke() {
        withContext(dispatchers.io()) {
            weatherRepository.deleteAllFavorite()
        }
    }
}