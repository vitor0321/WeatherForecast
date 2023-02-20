package com.walcker.weatherforecast.presentation.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
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

@Preview
@Composable
fun MainErrorScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.primary
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
        }
    }
}