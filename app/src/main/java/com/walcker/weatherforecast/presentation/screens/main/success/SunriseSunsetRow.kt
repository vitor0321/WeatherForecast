package com.walcker.weatherforecast.presentation.screens.main.success

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.walcker.core.data.utils.formatDateTime
import com.walcker.core.model.WeatherItemUI
import com.walcker.weatherforecast.R

@Composable
fun SunriseSunsetRow(weatherItemUI: WeatherItemUI) {

    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.padding(4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.sunrise),
                contentDescription = "sunrise",
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colors.secondary
            )
            Text(
                text = " ${formatDateTime(weatherItemUI.sunrise)}",
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.secondary
            )
        }
        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = "${formatDateTime(weatherItemUI.sunset)} ",
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.secondary
            )
            Icon(
                painter = painterResource(id = R.drawable.sunset),
                contentDescription = "sunset",
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colors.secondary
            )
        }
    }
}