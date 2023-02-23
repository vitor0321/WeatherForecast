package com.walcker.weatherforecast.presentation.screens.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.walcker.core.data.constants.UnitStateEnum
import com.walcker.core.model.UnitUI
import com.walcker.weatherforecast.presentation.components.ShowShortToast
import com.walcker.weatherforecast.presentation.components.WeatherTopBar

@Composable
fun SettingsScreen(
    navController: NavHostController,
    settingsViewModel: SettingsViewModel = hiltViewModel()
) {

    val choiceFromDB = settingsViewModel.unitList.collectAsState().value
    val unitToggleState = remember { mutableStateOf(false) }
    val choiceState = remember { mutableStateOf("") }
    choiceState.value = choiceFromDB
    unitToggleState.value = choiceState.value == UnitStateEnum.IMPERIAL.value

    Scaffold(
        topBar = {
            WeatherTopBar(
                title = "Settings",
                icon = Icons.Default.ArrowBack,
                navController = navController,
                isMainScreen = false,
                textColor = MaterialTheme.colors.secondary,
                elevation = 5.dp
            ) {
                navController.popBackStack()
            }
        },
        backgroundColor = MaterialTheme.colors.primary
    ) { scaffold ->
        scaffold.calculateTopPadding()

        Surface(modifier = Modifier.fillMaxSize()) {

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Change Units of Measurement",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(18.dp),
                    color = MaterialTheme.colors.secondary
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    onClick = {
                        settingsViewModel.deleteAllUnits()
                        settingsViewModel.insertUnits(UnitUI(unit = if (choiceState.value == UnitStateEnum.IMPERIAL.value) UnitStateEnum.METRIC.value else UnitStateEnum.IMPERIAL.value))
                        unitToggleState.value = !unitToggleState.value
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (unitToggleState.value) MaterialTheme.colors.onSecondary else MaterialTheme.colors.onBackground
                    ),
                    shape = RectangleShape,
                ) {
                    Text(
                        text = if (unitToggleState.value) "Fahrenheit ºF" else "Celsius ºC",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}