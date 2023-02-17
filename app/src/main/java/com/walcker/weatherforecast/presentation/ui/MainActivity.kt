package com.walcker.weatherforecast.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.walcker.weatherforecast.navigation.WeatherNavigation
import com.walcker.weatherforecast.presentation.ui.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { WeatherApp {} }
    }
}

@Composable
fun WeatherApp(content: @Composable () -> Unit) {
    WeatherTheme {
        content()
        WeatherNavigation()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherApp { }
}