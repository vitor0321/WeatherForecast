package com.walcker.weatherforecast.presentation.screens.favorite

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walcker.core.model.FavoriteUI
import com.walcker.core.usecase.*
import com.walcker.core.usecase.base.CoroutinesDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val deleteAllFavorites: DeleteAllFavorites,
    private val deleteFavorites: DeleteFavorites,
    private val getFavorites: GetFavorites,
    private val getFavoritesById: GetFavoritesById,
    private val insertFavorites: InsertFavorites,
    private val updateFavorites: UpdateFavorites,
    private val dispatchers: CoroutinesDispatchers
) : ViewModel() {

    private val _favoriteList = MutableStateFlow<List<FavoriteUI>>(emptyList())
    val favoriteList = _favoriteList.asStateFlow()

    init {
        viewModelScope.launch(dispatchers.main()) {
            getFavorites().distinctUntilChanged()
                .collect { listOfFavorites ->
                    if (listOfFavorites.isEmpty()) {
                        _favoriteList.value = listOf()
                    } else {
                        _favoriteList.value = listOfFavorites
                    }
                }
        }
    }

    fun deleteAllFavorites() = viewModelScope.launch(dispatchers.main()) { deleteAllFavorites.invoke() }

    fun deleteFavorites(favoriteUI: FavoriteUI) = viewModelScope.launch(dispatchers.main()) { deleteFavorites.invoke(DeleteFavorites.Params(favoriteUI = favoriteUI)) }

    fun getFavoriteById(city: String) = viewModelScope.launch(dispatchers.main()) { getFavoritesById(GetFavoritesById.Params(city = city)) }

    fun insertFavorite(favoriteUI: FavoriteUI) = viewModelScope.launch(dispatchers.main()) { insertFavorites(InsertFavorites.Params(favoriteUI = favoriteUI)) }

    fun updateFavorite(favoriteUI: FavoriteUI) = viewModelScope.launch(dispatchers.main()) { updateFavorites(UpdateFavorites.Params(favoriteUI = favoriteUI)) }
}