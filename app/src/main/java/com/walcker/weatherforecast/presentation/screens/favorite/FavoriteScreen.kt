package com.walcker.weatherforecast.presentation.screens.favorite

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.walcker.core.model.FavoriteUI
import com.walcker.weatherforecast.navigation.WeatherScreens
import com.walcker.weatherforecast.presentation.components.WeatherTopBar

@Composable
fun FavoriteScreen(
    navController: NavHostController,
    favoriteViewModel: FavoriteViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            WeatherTopBar(
                title = "Favorites Cities",
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
    ) { scaffold ->
        scaffold.calculateTopPadding()

        Surface(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxSize()
        ) {

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val favoriteList = favoriteViewModel.favoriteList.collectAsState().value

                LazyColumn {
                    items(items = favoriteList) {
                        CityRow(
                            favoriteUI = it,
                            favoriteViewModel = favoriteViewModel,
                            navController = navController
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun CityRow(
    favoriteUI: FavoriteUI,
    favoriteViewModel: FavoriteViewModel,
    navController: NavHostController
) {
    val context = LocalContext.current

    Surface(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .height(50.dp)
            .clickable {
                navController.navigate(WeatherScreens.MainScreen.name + "/${favoriteUI.city}")
            },
        shape = CircleShape.copy(topEnd = CornerSize(6.dp)),
        color = MaterialTheme.colors.onPrimary
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                modifier= Modifier.padding(start = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = favoriteUI.city,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 4.dp)
                )

                Spacer(modifier = Modifier.padding(14.dp))

                Surface(
                    modifier = Modifier.padding(0.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colors.onSecondary
                ) {

                    Text(
                        text = favoriteUI.country,
                        color = Color.White,
                        modifier = Modifier
                            .padding(4.dp),
                        style = MaterialTheme.typography.caption
                    )
                }
            }

            Row(
                modifier = Modifier.padding(end = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {

                Icon(
                    imageVector = Icons.Rounded.Delete,
                    contentDescription = "delete favorite",
                    modifier = Modifier.clickable {
                        favoriteViewModel.deleteFavorites(favoriteUI).also {
                            Toast.makeText(context, "Delete city by favorite", Toast.LENGTH_SHORT).show()
                        }
                    },
                    tint = Color.Red.copy(alpha = 0.5f)
                )
            }
        }
    }
}
