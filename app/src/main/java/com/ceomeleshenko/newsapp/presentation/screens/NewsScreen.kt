package com.ceomeleshenko.newsapp.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.ceomeleshenko.newsapp.presentation.view_models.NewsViewModel

@Composable
fun NewsScreen(viewModel: NewsViewModel = hiltViewModel()) {
    val news = viewModel.news.observeAsState()
    Text(text = "News Screen")
}