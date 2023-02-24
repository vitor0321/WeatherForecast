package com.walcker.weatherforecast.presentation.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.walcker.core.data.constants.MenuEnum
import com.walcker.core.model.FavoriteUI
import com.walcker.weatherforecast.navigation.WeatherScreens
import com.walcker.weatherforecast.presentation.screens.favorite.FavoriteViewModel

@Composable
fun WeatherTopBar(
    title: String = "title",
    textColor: Color,
    icon: ImageVector? = null,
    isMainScreen: Boolean = true,
    navController: NavController,
    favoriteViewModel: FavoriteViewModel = hiltViewModel(),
    elevation: Dp = 0.dp,
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: () -> Unit = {}
) {
    val showDialog = remember { mutableStateOf(false) }
    val context = LocalContext.current

    if (showDialog.value) {
        ShowSettingDropDownMenu(showDialog = showDialog, navController = navController)
    }

    val isAlreadyFavoriteList = favoriteViewModel.favoriteList.collectAsState().value.filter { item ->
        (item.city == title.split(",")[0])
    }

    Column {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    color = textColor,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                )
            },
            actions = {
                if (isMainScreen) {
                    IconButton(onClick = { onAddActionClicked() }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search button",
                            tint = Color.LightGray
                        )
                    }
                    IconButton(onClick = {
                        showDialog.value = true
                    }) {
                        Icon(
                            imageVector = Icons.Rounded.MoreVert,
                            contentDescription = "More Icon",
                            tint = Color.LightGray
                        )
                    }
                } else Box {}
            },
            navigationIcon = {
                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Go back",
                        modifier = Modifier.clickable {
                            onButtonClicked()
                        },
                        tint = MaterialTheme.colors.secondary
                    )
                }
                if (isMainScreen) {
                    if (isAlreadyFavoriteList.isEmpty()) {
                        Icon(
                            imageVector = Icons.Rounded.Favorite,
                            contentDescription = "favorite icon",
                            tint = Color.Red.copy(alpha = 0.3f),
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .scale(0.9f)
                                .clickable {
                                    val dataCity = title.split(",")
                                    favoriteViewModel.insertFavorite(
                                        FavoriteUI(
                                            city = dataCity[0],
                                            country = dataCity[1]
                                        )
                                    ).also {
                                        Toast.makeText(context, "Add city in Favorite", Toast.LENGTH_SHORT).show()
                                    }
                                }
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "favorite icon",
                            tint = Color.Red.copy(alpha = 0.9f),
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .scale(0.9f)
                                .clickable {
                                    val dataCity = title.split(",")
                                    favoriteViewModel.deleteFavorites(
                                        FavoriteUI(
                                            city = dataCity[0],
                                            country = dataCity[1]
                                        )
                                    ).also {
                                        Toast.makeText(context, "Delete city by favorite", Toast.LENGTH_SHORT).show()
                                    }
                                }
                        )
                    }
                }
            },
            backgroundColor = Color.Transparent,
            elevation = elevation,
        )
        Divider(color = Color.LightGray)
    }
}

@Composable
fun ShowSettingDropDownMenu(
    showDialog: MutableState<Boolean>,
    navController: NavController
) {
    var expanded by remember { mutableStateOf(true) }
    val items = listOf(MenuEnum.MENU_ABOUT, MenuEnum.MENU_FAVORITES, MenuEnum.MENU_SETTINGS)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
            .absolutePadding(top = 45.dp, right = 20.dp)
    ) {
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(140.dp)
                .background(MaterialTheme.colors.primary)
        ) {

            items.forEachIndexed { index, text ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    showDialog.value = false
                }) {
                    Row(
                        modifier = Modifier.clickable {
                            navController.navigate(
                                when (text) {
                                    MenuEnum.MENU_ABOUT -> WeatherScreens.AboutScreen.name
                                    MenuEnum.MENU_FAVORITES -> WeatherScreens.FavoriteScreen.name
                                    MenuEnum.MENU_SETTINGS -> WeatherScreens.SettingsScreen.name
                                }
                            )
                        },
                    ) {
                        Icon(
                            imageVector = when (text) {
                                MenuEnum.MENU_ABOUT -> Icons.Default.Info
                                MenuEnum.MENU_FAVORITES -> Icons.Default.FavoriteBorder
                                MenuEnum.MENU_SETTINGS -> Icons.Default.Settings
                            },
                            contentDescription = null,
                            tint = MaterialTheme.colors.onPrimary
                        )

                        Spacer(modifier = Modifier.size(4.dp))

                        Text(
                            text = text.item,
                            fontWeight = FontWeight.W300
                        )
                    }
                }
            }
        }
    }
}
