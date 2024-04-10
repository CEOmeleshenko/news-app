package com.ceomeleshenko.newsapp.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.ceomeleshenko.newsapp.presentation.components.NewsItem
import com.ceomeleshenko.newsapp.presentation.view_models.NewsViewModel

@Composable
fun NewsScreen(
    viewModel: NewsViewModel,
    navController: NavController,
) {
    val news = viewModel.news.observeAsState(emptyList())

    LazyColumn {
        if (news.value.isNotEmpty()) items(news.value) { news ->
            NewsItem(news, onClick = {
                viewModel.selectNews(it)
                navController.navigate("detail_news")
            })
        }
    }
}