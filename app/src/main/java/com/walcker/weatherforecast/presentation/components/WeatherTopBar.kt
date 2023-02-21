package com.walcker.weatherforecast.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.walcker.core.data.constants.MenuEnum
import com.walcker.weatherforecast.navigation.WeatherScreens

@Composable
fun WeatherTopBar(
    title: String = "title",
    textColor: Color,
    icon: ImageVector? = null,
    isMainScreen: Boolean = true,
    navController: NavController,
    elevation: Dp = 0.dp,
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: () -> Unit = {}
) {

    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value) {
        ShowSettingDropDownMenu(showDialog = showDialog, navController = navController)
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
                        modifier = Modifier.clickable {
                            navController.navigate(
                                when (text) {
                                    MenuEnum.MENU_ABOUT -> WeatherScreens.AboutScreen.name
                                    MenuEnum.MENU_FAVORITES -> WeatherScreens.FavoriteScreen.name
                                    MenuEnum.MENU_SETTINGS -> WeatherScreens.SettingsScreen.name
                                }
                            )
                        },
                        text = text.item,
                        fontWeight = FontWeight.W300
                    )
                }
            }
        }
    }
}
