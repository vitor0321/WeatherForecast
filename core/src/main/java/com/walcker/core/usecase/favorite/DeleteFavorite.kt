package com.walcker.core.usecase.favorite

import com.walcker.core.data.repository.WeatherLocalRepository
import com.walcker.core.model.FavoriteUI
import com.walcker.core.usecase.base.CoroutinesDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface DeleteFavorites {

    suspend operator fun invoke(params: Params)

    data class Params(val favoriteUI: FavoriteUI)

}

class DeleteFavoritesImpl @Inject constructor(
    private val weatherRepository: WeatherLocalRepository,
    private val dispatchers: CoroutinesDispatchers
) : DeleteFavorites {

    override suspend fun invoke(params: DeleteFavorites.Params){
        withContext(dispatchers.io()){
            weatherRepository.deleteFavorite(params.favoriteUI)
        }
    }
}