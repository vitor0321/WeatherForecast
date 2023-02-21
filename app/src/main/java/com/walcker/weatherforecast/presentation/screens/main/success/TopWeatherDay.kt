package com.walcker.weatherforecast.presentation.screens.main.success

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.walcker.core.data.utils.formatDate
import com.walcker.core.data.utils.formatDecimals
import com.walcker.core.model.WeatherResponseUI
import com.walcker.weatherforecast.presentation.components.WeatherStateImage

@Composable
fun TopWeatherDay(weatherResponseUI: WeatherResponseUI) {

    val imageUrl = "https://openweathermap.org/img/wn/${weatherResponseUI.listWeatherItem[0].weather[0].icon}.png"

    Text(
        text = formatDate(weatherResponseUI.listWeatherItem[0].dt), // Wed Nov 30,
        style = MaterialTheme.typography.h6,
        color = MaterialTheme.colors.secondary,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(6.dp)
    )

    Surface(
        modifier = Modifier
            .padding(4.dp)
            .size(200.dp),
        shape = CircleShape,
        color = MaterialTheme.colors.onSurface
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            WeatherStateImage(imageUrl = imageUrl)

            Text(
                text = formatDecimals(weatherResponseUI.listWeatherItem[0].day) + "ºC",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = weatherResponseUI.listWeatherItem[0].weather[0].main,
                fontStyle = FontStyle.Italic
            )
        }
    }
}