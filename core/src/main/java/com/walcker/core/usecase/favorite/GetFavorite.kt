package com.walcker.core.usecase.favorite

import com.walcker.core.data.repository.WeatherLocalRepository
import com.walcker.core.model.FavoriteUI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetFavorites {

     operator fun invoke(): Flow<List<FavoriteUI>>
}

class GetFavoritesImpl @Inject constructor(
    private val weatherRepository: WeatherLocalRepository
) : GetFavorites {

    override fun invoke(): Flow<List<FavoriteUI>>{
       return weatherRepository.getFavorites()
    }
}