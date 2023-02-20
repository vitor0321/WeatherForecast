package com.walcker.weatherforecast.presentation.screens.main

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.walcker.core.model.WeatherResponseUI
import com.walcker.weatherforecast.presentation.components.WeatherTopBar

@Composable
fun MainDataScreen(
    weatherResponseUI: WeatherResponseUI,
    navController: NavController
) {

    Scaffold(
        topBar = {
            WeatherTopBar(
                title = weatherResponseUI.nameCity + ", " + weatherResponseUI.country,
                textColor = MaterialTheme.colors.secondary,
                navController = navController,
                elevation = 5.dp
            )
        },
        backgroundColor = MaterialTheme.colors.primary
    ) {
        it.calculateTopPadding()
        MainContent(weatherResponseUI = weatherResponseUI)
    }
}

@Composable
fun MainContent(weatherResponseUI: WeatherResponseUI) {
    Text(
        text = weatherResponseUI.nameCity,
        color = MaterialTheme.colors.secondary
    )
}