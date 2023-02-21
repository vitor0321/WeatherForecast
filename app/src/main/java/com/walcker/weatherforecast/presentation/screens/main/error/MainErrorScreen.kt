package com.walcker.weatherforecast.presentation.screens.main.error

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.walcker.weatherforecast.navigation.WeatherScreens

@Composable
fun MainErrorScreen(
    navController: NavHostController,
    exception: Exception?,
) {

    val defaultCity = "São Paulo"

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.primary
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (exception?.message == "HTTP 404 Not Found") {

                Icon(
                    modifier = Modifier
                        .size(94.dp),
                    imageVector = Icons.Outlined.Warning,
                    tint = Color.Red,
                    contentDescription = "hummm !!! something is wrong"
                )
                Text(
                    modifier = Modifier.padding(all = 22.dp),
                    text = "This city isn't valid",
                    color = MaterialTheme.colors.secondary,
                    fontSize = 26.sp,
                    textAlign = TextAlign.Center
                )
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                    onClick = { navController.navigate(WeatherScreens.SearchScreen.name) }) {
                    Text(
                        text = "Search new city",
                        color = Color.Red,
                        fontSize = 18.sp,
                    )
                }
            } else {
                Icon(
                    modifier = Modifier
                        .size(234.dp),
                    imageVector = Icons.Outlined.Warning,
                    tint = Color.Red,
                    contentDescription = "hummm !!! something is wrong"
                )
                Text(
                    modifier = Modifier.padding(all = 22.dp),
                    text = "Hummm!! Something is wrong. Check your connection.",
                    color = MaterialTheme.colors.secondary,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                    onClick = { navController.navigate(WeatherScreens.MainScreen.name+ "/$defaultCity") }) {
                    Text(
                        text = "Try again",
                        color = Color.Red,
                        fontSize = 18.sp,
                    )
                }
            }
        }
    }
}