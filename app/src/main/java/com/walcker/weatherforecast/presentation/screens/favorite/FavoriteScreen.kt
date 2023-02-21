package com.walcker.weatherforecast.presentation.screens.favorite

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.walcker.weatherforecast.presentation.components.WeatherTopBar

@Composable
fun FavoriteScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            WeatherTopBar(
                title = "Favorite",
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
    ) {
     it.calculateTopPadding()
    }
}