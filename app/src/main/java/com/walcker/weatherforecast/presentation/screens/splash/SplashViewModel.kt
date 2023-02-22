package com.walcker.weatherforecast.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walcker.core.model.FavoriteUI
import com.walcker.core.usecase.GetFavorites
import com.walcker.core.usecase.base.CoroutinesDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getFavorites: GetFavorites,
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
}