package com.walcker.weatherforecast.presentation.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.walcker.core.data.constants.Constants.DEFAULT_CITY
import com.walcker.weatherforecast.R
import com.walcker.weatherforecast.navigation.WeatherScreens
import com.walcker.weatherforecast.presentation.screens.favorite.FavoriteViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {

    val scale = remember { Animatable(0f) }
    val defaultCity = remember { mutableStateOf(DEFAULT_CITY) }

    val favoriteList = splashViewModel.favoriteList.collectAsState().value
    defaultCity.value = if (favoriteList.isNotEmpty()) favoriteList.first().city else DEFAULT_CITY


    LaunchedEffect(key1 = true, block = {
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(durationMillis = 800,
                easing = { OvershootInterpolator(8f).getInterpolation(it) }
            )
        )
        delay(1000L)
        navController.navigate(WeatherScreens.MainScreen.name + "/${defaultCity.value}")
    })

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.primary
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .scale(scale.value)
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {

            CircularProgressIndicator(
                modifier = Modifier.size(290.dp),
                color = Color.Red,
            )
            Surface(
                modifier = Modifier.size(300.dp),
                shape = CircleShape,
                color = Color.Transparent,
                border = BorderStroke(
                    width = 2.dp,
                    color = Color.Gray
                )
            ) {
                Column(
                    modifier = Modifier.padding(1.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Image(
                        modifier = Modifier.size(96.dp),
                        painter = painterResource(id = R.drawable.sun),
                        contentDescription = "Sunny icon",
                        contentScale = ContentScale.Fit,
                        colorFilter = ColorFilter.tint(color = Color.Red)
                    )
                    Text(
                        text = "Find the Sun?",
                        style = MaterialTheme.typography.h5,
                        color = Color.Green
                    )
                }
            }
        }
    }
}
