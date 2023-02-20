package com.walcker.weatherforecast.presentation.screens.search

import androidx.lifecycle.ViewModel
import com.walcker.core.usecase.base.CoroutinesDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val dispatchers: CoroutinesDispatchers
    ) : ViewModel() {
}