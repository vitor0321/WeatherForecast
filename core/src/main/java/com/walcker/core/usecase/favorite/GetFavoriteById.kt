package com.walcker.core.usecase.favorite

import com.walcker.core.data.repository.WeatherLocalRepository
import com.walcker.core.model.FavoriteUI
import com.walcker.core.usecase.base.CoroutinesDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface GetFavoritesById {

    suspend operator fun invoke(params: Params): FavoriteUI

    data class Params(val city: String)

}

class GetFavoritesByIdImpl @Inject constructor(
    private val weatherRepository: WeatherLocalRepository,
    private val dispatchers: CoroutinesDispatchers
) : GetFavoritesById {

    override suspend fun invoke(params: GetFavoritesById.Params): FavoriteUI {
        return withContext(dispatchers.io()){
            weatherRepository.getFavoriteById(params.city)
        }
    }
}