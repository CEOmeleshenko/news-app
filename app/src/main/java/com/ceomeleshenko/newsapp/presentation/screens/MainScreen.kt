package com.ceomeleshenko.newsapp.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ceomeleshenko.newsapp.presentation.components.BottomNavigation
import com.ceomeleshenko.newsapp.presentation.view_models.NewsViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val viewModel: NewsViewModel = hiltViewModel()

    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "news",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("news") {
                NewsScreen(
                    navController = navController,
                    viewModel = viewModel
                )
            }
            composable("info") { InfoScreen() }
            composable(route = "detail_news") {
                DetailNewsScreen(
                    navController = navController,
                    viewModel = viewModel
                )
            }
        }
    }
}