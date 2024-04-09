package com.ceomeleshenko.newsapp.domain

import com.ceomeleshenko.newsapp.data.NewsRepository
import com.ceomeleshenko.newsapp.data.models.News
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend fun execute(): List<News> {
        return newsRepository.getNews()
    }
}