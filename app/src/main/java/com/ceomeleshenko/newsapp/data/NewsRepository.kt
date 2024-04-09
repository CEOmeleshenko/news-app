package com.ceomeleshenko.newsapp.data

import com.ceomeleshenko.newsapp.data.models.News
import com.ceomeleshenko.newsapp.data.models.RedditResponse
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsApiService: NewsApiService
) {
    suspend fun getNews(): List<News> {

        val news = mutableListOf<News>()

        val redditPosts = newsApiService.getNews().body()?.data?.children

        redditPosts?.forEach { post ->
            news.add(
                News(
                    title = post.data.title,
                    thumbnail = post.data.thumbnail,
                    created_utc = post.data.created_utc
                )
            )
        }

        return news
    }
}