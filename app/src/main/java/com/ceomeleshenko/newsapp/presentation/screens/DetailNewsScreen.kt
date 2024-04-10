package com.ceomeleshenko.newsapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.ceomeleshenko.newsapp.data.models.News
import com.ceomeleshenko.newsapp.presentation.view_models.NewsViewModel

@Composable
fun DetailNewsScreen(
    navController: NavController,
    viewModel: NewsViewModel
) {
    val news by viewModel.selectedNews.observeAsState(News())

    if (news == null) navController.navigate("news")

    Column {
        Text(text = news.title)
        PictureNews(url = news.url)
        Text(text = news.author)
        Text(text = news.created)
        Text(text = news.selftext)
    }
}

@Composable
private fun PictureNews(url: String) {
    SubcomposeAsyncImage(
        model = url,
        contentDescription = null,
    ) {
        val state = painter.state
        if (state is AsyncImagePainter.State.Success) {
            SubcomposeAsyncImageContent(
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Fit,
            )
        }
    }
}