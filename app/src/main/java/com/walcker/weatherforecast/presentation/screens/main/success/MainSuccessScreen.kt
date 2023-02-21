package com.walcker.weatherforecast.presentation.screens.main.success

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.walcker.core.data.utils.formatDateWeek
import com.walcker.core.data.utils.formatDecimals
import com.walcker.core.model.WeatherItemUI
import com.walcker.core.model.WeatherResponseUI
import com.walcker.weatherforecast.presentation.components.WeatherStateImage
import com.walcker.weatherforecast.presentation.components.WeatherTopBar

@Composable
fun MainSuccessScreen(
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

        Column(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TopWeatherDay(weatherResponseUI)

            HumidityWindPressureRow(weatherItemUI = weatherResponseUI.listWeatherItem[0])

            Divider(color = MaterialTheme.colors.onBackground, thickness = 0.3.dp)

            SunriseSunsetRow(weatherItemUI = weatherResponseUI.listWeatherItem[0])

            WeatherOfWeekColumn(listWeatherItemUI = weatherResponseUI.listWeatherItem)
        }
    }
}
