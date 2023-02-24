package com.walcker.weatherforecast.presentation.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.walcker.weatherforecast.navigation.WeatherScreens
import com.walcker.weatherforecast.presentation.components.SearchTextField
import com.walcker.weatherforecast.presentation.components.WeatherTopBar

@Composable
fun SearchScreen(
    navController: NavHostController,
) {

    Scaffold(
        topBar = {
            WeatherTopBar(
                title = "Searcher",
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
        Surface {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SearchTextField {cityName->
                    navController.navigate(WeatherScreens.MainScreen.name + "/$cityName")
                }
            }
        }
    }
}
