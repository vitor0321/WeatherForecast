package com.walcker.weatherforecast.presentation.screens.main.success

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walcker.core.data.utils.formatDateWeek
import com.walcker.core.data.utils.formatDecimals
import com.walcker.core.model.WeatherItemUI
import com.walcker.weatherforecast.presentation.components.WeatherStateImage

@Composable
fun WeatherOfWeekColumn(listWeatherItemUI: List<WeatherItemUI>) {

    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(12.dp),
            text = "This Week",
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colors.secondary
        )
    }

    LazyColumn(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
        contentPadding = PaddingValues(1.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(items = listWeatherItemUI) { weatherItemUI ->

            val imageUrl = "https://openweathermap.org/img/wn/${weatherItemUI.weather[0].icon}.png"

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(topStart = 22.dp, bottomStart = 22.dp, bottomEnd = 22.dp)
            ) {
                Row(
                    modifier = Modifier.padding(6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = formatDateWeek(weatherItemUI.dt),
                        color = MaterialTheme.colors.secondary,
                        fontWeight = FontWeight.SemiBold
                    )

                    WeatherStateImage(imageUrl = imageUrl)

                    Card(
                        shape = RoundedCornerShape(12.dp),
                        backgroundColor = MaterialTheme.colors.onSurface
                    ) {
                        Text(
                            modifier = Modifier.padding(4.dp),
                            text = weatherItemUI.weather[0].description,
                            color = Color.Black
                        )
                    }

                    Text(text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colors.onSecondary,
                                fontSize = 24.sp,
                            )
                        ){
                            append(formatDecimals(weatherItemUI.max) + "º ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colors.onBackground,
                                fontSize = 12.sp,
                            )
                        ){
                            append(formatDecimals(weatherItemUI.min) + "º")
                        }
                    })
                }
            }
        }
    }
}
