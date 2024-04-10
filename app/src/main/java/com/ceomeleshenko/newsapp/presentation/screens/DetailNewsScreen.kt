package com.ceomeleshenko.newsapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ceomeleshenko.newsapp.data.models.News
import com.ceomeleshenko.newsapp.other.theme.Typography
import com.ceomeleshenko.newsapp.presentation.components.PictureNews
import com.ceomeleshenko.newsapp.presentation.view_models.NewsViewModel

@Composable
fun DetailNewsScreen(
    navController: NavController,
    viewModel: NewsViewModel
) {
    val news by viewModel.selectedNews.observeAsState(News())

    if (news == null) navController.navigate("news")

    Column {
        Text(
            text = news.title,
            style = Typography.titleLarge,
            modifier = Modifier
                .padding(10.dp)
        )
        PictureNews(url = news.url, Modifier.padding(10.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = news.author,
                style = Typography.titleSmall
            )
            Text(
                text = news.created,
                style = Typography.titleSmall
            )
        }
        Text(
            text = news.selftext,
            style = Typography.bodyMedium,
            modifier =  Modifier
                .fillMaxWidth()
                .padding(10.dp, 5.dp)
        )
    }
}