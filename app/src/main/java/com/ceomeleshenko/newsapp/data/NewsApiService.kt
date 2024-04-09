package com.ceomeleshenko.newsapp.data

import com.ceomeleshenko.newsapp.data.models.RedditResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("r/linux/top.json")
    suspend fun getNews(
        @Query("limit") limit: Int = 7,
        @Query("t") time: String = "week",
        @Query("after") after: String? = null
    ): Response<RedditResponse>
}