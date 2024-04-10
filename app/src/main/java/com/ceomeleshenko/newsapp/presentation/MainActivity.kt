package com.ceomeleshenko.newsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ceomeleshenko.newsapp.presentation.screens.DetailNewsScreen
import com.ceomeleshenko.newsapp.presentation.screens.InfoScreen
import com.ceomeleshenko.newsapp.presentation.screens.NewsScreen
import com.ceomeleshenko.newsapp.presentation.view_models.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: NewsViewModel = hiltViewModel()

            NavHost(navController = navController, startDestination = "news") {
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
}