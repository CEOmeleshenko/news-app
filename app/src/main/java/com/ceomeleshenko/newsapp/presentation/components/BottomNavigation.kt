package com.ceomeleshenko.newsapp.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ceomeleshenko.newsapp.R

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        NavigationItem.News,
        NavigationItem.Info
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = stringResource(id = item.titleResource)
                    )
                },
                label = { Text(stringResource(id = item.titleResource)) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = false
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

private sealed class NavigationItem(
    val route: String,
    val icon: ImageVector,
    val titleResource: Int
) {
    data object News : NavigationItem("news", Icons.Rounded.Star, R.string.menu_item_news)
    data object Info : NavigationItem("info", Icons.Rounded.Info, R.string.menu_item_info)
}