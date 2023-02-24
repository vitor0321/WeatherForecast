package com.walcker.weatherforecast.presentation.screens.about

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.walcker.core.data.utils.formatDecimals
import com.walcker.weatherforecast.R
import com.walcker.weatherforecast.presentation.components.WeatherTopBar

@Composable
fun AboutScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            WeatherTopBar(
                title = "About",
                icon = Icons.Default.ArrowBack,
                navController = navController,
                isMainScreen = false,
                textColor = MaterialTheme.colors.secondary,
                elevation = 5.dp
            ) {
                navController.popBackStack()
            }
        },
        backgroundColor = MaterialTheme.colors.primary
    ) {
        it.calculateTopPadding()

        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.size(10.dp))

                Text(
                    text = stringResource(id = R.string.app_name),
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(modifier = Modifier.size(10.dp))

                Text(
                    modifier = Modifier.padding(12.dp),
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Red,
                                fontSize = 24.sp,
                            )
                        ) {
                            append(text = stringResource(id = R.string.why_open_weather))
                        }
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colors.onBackground,
                                fontSize = 18.sp,
                            )
                        ) {
                            append(text = stringResource(id = R.string.open_weather_is_a_team))
                        }
                    })

                Spacer(modifier = Modifier.size(10.dp))

                Text(
                    modifier = Modifier.padding(12.dp),
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colors.primary,
                                fontSize = 20.sp,
                            )
                        ) {
                            append(text = stringResource(id = R.string.our_highly_efficient_technological))
                        }
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colors.onBackground,
                                fontSize = 18.sp,
                            )
                        ) {
                            append(text = stringResource(id = R.string.the_proprietary_convolutional))
                        }
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colors.primary,
                                fontSize = 18.sp,
                            )
                        ) {
                            append(text = stringResource(id = R.string.we_collect_and_process))
                        }
                    })

                Spacer(modifier = Modifier.size(10.dp))

                Text(
                    modifier = Modifier.padding(12.dp),
                    text = stringResource(id = R.string.about_more_info),
                    color = Color.Red,
                    fontSize = 24.sp,
                )

                Text(
                    modifier = Modifier.padding(12.dp),
                    text = stringResource(id = R.string.http_open_weather_map),
                    color = MaterialTheme.colors.onBackground,
                    fontSize = 18.sp,
                )
            }
        }
    }
}