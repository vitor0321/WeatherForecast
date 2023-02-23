package com.walcker.core.usecase.favorite

import com.walcker.core.data.repository.WeatherLocalRepository
import com.walcker.core.model.FavoriteUI
import com.walcker.core.usecase.base.CoroutinesDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface UpdateFavorites {

    suspend operator fun invoke(params: Params)

    data class Params(val favoriteUI: FavoriteUI)
}

class UpdateFavoritesImpl @Inject constructor(
    private val weatherRepository: WeatherLocalRepository,
    private val dispatchers: CoroutinesDispatchers
) : UpdateFavorites {

    override suspend fun invoke(params: UpdateFavorites.Params){
        withContext(dispatchers.io()){
            weatherRepository.updateFavorite(params.favoriteUI)
        }
    }
}