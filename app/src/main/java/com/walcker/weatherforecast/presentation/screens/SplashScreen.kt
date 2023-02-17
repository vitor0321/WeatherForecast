package com.walcker.weatherforecast.presentation.screens

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.walcker.weatherforecast.R

@Composable
fun SplashScreen(navController: NavHostController) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {

            CircularProgressIndicator(
                modifier= Modifier.size(290.dp),
                color = Color.Red,
            )
            Surface(
                modifier = Modifier
                    .padding(15.dp)
                    .size(300.dp),
                shape = CircleShape,
                color = Color.Transparent,
                border = BorderStroke(
                    width = 2.dp,
                    color = Color.Blue
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
                        colorFilter = ColorFilter.tint(color= Color.Yellow)
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
