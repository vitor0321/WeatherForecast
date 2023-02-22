package com.walcker.weatherforecast.presentation.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun ShowShortToast(message: String) = Toast.makeText(LocalContext.current, message, Toast.LENGTH_SHORT).show()

@Composable
fun ShowLogToast(message: String) = Toast.makeText(LocalContext.current, message, Toast.LENGTH_LONG).show()
