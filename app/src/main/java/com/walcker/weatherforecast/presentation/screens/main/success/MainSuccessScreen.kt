package com.walcker.weatherforecast.presentation.screens.main.success

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.walcker.core.model.WeatherResponseUI
import com.walcker.weatherforecast.navigation.WeatherScreens
import com.walcker.weatherforecast.presentation.components.WeatherTopBar

@Composable
fun MainSuccessScreen(
    weatherResponseUI: WeatherResponseUI,
    navController: NavController,
    isImperial: MutableState<Boolean>
) {

    Scaffold(
        topBar = {
            WeatherTopBar(
                title = weatherResponseUI.nameCity + ", " + weatherResponseUI.country,
                textColor = MaterialTheme.colors.secondary,
                navController = navController,
                onAddActionClicked = {
                    navController.navigate(WeatherScreens.SearchScreen.name)
                },
                elevation = 5.dp
            )
        },
        backgroundColor = MaterialTheme.colors.primary
    ) {
        it.calculateTopPadding()

        Column(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TopWeatherDay(weatherResponseUI = weatherResponseUI, isImperial = isImperial)

            HumidityWindPressureRow(weatherItemUI = weatherResponseUI.listWeatherItem[0], isImperial = isImperial)

            Divider(color = MaterialTheme.colors.onBackground, thickness = 0.3.dp)

            SunriseSunsetRow(weatherItemUI = weatherResponseUI.listWeatherItem[0])

            WeatherOfWeekColumn(listWeatherItemUI = weatherResponseUI.listWeatherItem)
        }
    }
}
