package com.ceomeleshenko.newsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ceomeleshenko.newsapp.presentation.screens.InfoScreen
import com.ceomeleshenko.newsapp.presentation.screens.NewsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "news") {
                composable("news") { NewsScreen() }
                composable("info") { InfoScreen() }
            }
        }
    }
}