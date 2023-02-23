package com.walcker.weatherforecast.presentation.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walcker.core.data.constants.UnitStateEnum
import com.walcker.core.model.UnitUI
import com.walcker.core.usecase.base.CoroutinesDispatchers
import com.walcker.core.usecase.settings.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val deleteAllUnits: DeleteAllUnitsSettings,
    private val deleteUnit: DeleteUnitSettings,
    private val getUnits: GetUnitsSettings,
    private val insertUnits: InsertUnitsSettings,
    private val updateUnit: UpdateUnitSettings,
    private val dispatchers: CoroutinesDispatchers
) : ViewModel() {

    private val _unitList = MutableStateFlow(UnitStateEnum.IMPERIAL.value)
    val unitList = _unitList.asStateFlow()

    init {
        viewModelScope.launch {
            getUnits().distinctUntilChanged()
                .collect { listOfUnits ->
                    if (listOfUnits.isNotEmpty()) {
                        _unitList.value = listOfUnits[0].unit
                    } else{
                        insertUnits(UnitUI(UnitStateEnum.IMPERIAL.value))
                    }
                }
        }
    }

    fun deleteAllUnits() = viewModelScope.launch(dispatchers.main()) { deleteAllUnits.invoke() }

    fun deleteUnit(unitUI: UnitUI) = viewModelScope.launch(dispatchers.main()) { deleteUnit.invoke(DeleteUnitSettings.Params(unitsUI = unitUI)) }

    fun insertUnits(unitUI: UnitUI) = viewModelScope.launch(dispatchers.main()) { insertUnits.invoke(InsertUnitsSettings.Params(unitUI = unitUI)) }

    fun updateUnits(unitUI: UnitUI) = viewModelScope.launch(dispatchers.main()) { updateUnit.invoke(UpdateUnitSettings.Params(unitUI = unitUI)) }
}