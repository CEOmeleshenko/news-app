package com.ceomeleshenko.newsapp.data

import android.annotation.SuppressLint
import com.ceomeleshenko.newsapp.data.models.News
import java.text.SimpleDateFormat
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsApiService: NewsApiService
) {
    @SuppressLint("SimpleDateFormat")
    suspend fun getNews(): List<News> {

        val redditPosts = newsApiService.getNews().body()?.data?.children
        val news = mutableListOf<News>()
        val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm")

        redditPosts?.forEach { post ->
            news.add(
                News(
                    author = post.data.author,
                    title = post.data.title,
                    selftext = post.data.selftext,
                    url = post.data.url,
                    created = simpleDateFormat.format(post.data.created * 1000)
                )
            )
        }

        return news
    }
}