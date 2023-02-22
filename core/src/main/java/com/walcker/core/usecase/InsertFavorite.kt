package com.walcker.core.usecase

import com.walcker.core.data.repository.WeatherLocalRepository
import com.walcker.core.model.FavoriteUI
import com.walcker.core.usecase.base.CoroutinesDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface InsertFavorites {

    suspend operator fun invoke(params: Params)

    data class Params(val favoriteUI: FavoriteUI)
}

class InsertFavoritesImpl @Inject constructor(
    private val weatherRepository: WeatherLocalRepository,
    private val dispatchers: CoroutinesDispatchers
) : InsertFavorites {

    override suspend fun invoke(params: InsertFavorites.Params){
        withContext(dispatchers.io()){
            weatherRepository.insertFavorite(params.favoriteUI)
        }
    }
}