package com.ceomeleshenko.newsapp.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Observer
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ceomeleshenko.newsapp.data.models.News
import com.ceomeleshenko.newsapp.presentation.components.BottomNavigation
import com.ceomeleshenko.newsapp.presentation.components.FeedbackDialog
import com.ceomeleshenko.newsapp.presentation.view_models.NewsViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val viewModel: NewsViewModel = hiltViewModel()

    val openNewsCounter by viewModel.openNewsCounter.observeAsState()
    val showDialog by viewModel.showFeedbackDialog.collectAsState()

    if (openNewsCounter == 3) viewModel.showDialog()

    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) { paddingValues ->

        if (showDialog) {
            FeedbackDialog(
                onDismiss = { viewModel.hideDialog() },
                onRate = {

                }
            )
        }

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