package com.ceomeleshenko.newsapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ceomeleshenko.newsapp.data.models.News
import com.ceomeleshenko.newsapp.other.theme.Typography

@Composable
fun NewsItem(
    news: News,
    onClick: (News) -> Unit
) {

    Card(
        modifier = Modifier
            .padding(10.dp)
            .clickable { onClick(news) },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        ),
        shape = RoundedCornerShape(20.dp),
        content = {
            Text(
                text = news.title,
                style = Typography.titleMedium,
                modifier = Modifier
                    .padding(10.dp, 5.dp)
                    .fillMaxWidth()
            )
            Text(
                text = news.created,
                style = Typography.titleSmall,
                modifier = Modifier
                    .padding(10.dp, 0.dp)
                    .align(Alignment.End)
            )
            PictureNews(url = news.url)
        }
    )
}