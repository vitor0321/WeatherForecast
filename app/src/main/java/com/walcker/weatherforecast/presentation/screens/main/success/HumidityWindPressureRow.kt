package com.walcker.weatherforecast.presentation.screens.main.success

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.walcker.core.data.utils.formatDecimals
import com.walcker.core.model.WeatherItemUI
import com.walcker.weatherforecast.R

@Composable
fun HumidityWindPressureRow(
    weatherItemUI: WeatherItemUI,
    isImperial: MutableState<Boolean>
) {

    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.padding(4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.humidity),
                contentDescription = "humidity",
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colors.secondary
            )
            Text(
                text = " ${weatherItemUI.humidity}%",
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.secondary
            )
        }
        Row {
            Icon(
                painter = painterResource(id = R.drawable.pressure),
                contentDescription = "pressure",
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colors.secondary
            )
            Text(
                text = " ${weatherItemUI.pressure} psi",
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.secondary
            )
        }
        Row {
            Icon(
                painter = painterResource(id = R.drawable.wind),
                contentDescription = "wind icon",
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colors.secondary
            )
            Text(
                text = " ${formatDecimals(weatherItemUI.speed)} " + if (isImperial.value) "mph" else "m/s",
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.secondary
            )
        }
    }
}
