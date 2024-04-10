package com.ceomeleshenko.newsapp.data.models

data class RedditResponse(
    val kind: String,
    val data: RedditData
) {
    data class RedditData(
        val modhash: String?,
        val dist: Int?,
        val children: List<RedditPostData>,
        val after: String?,
        val before: String?
    ) {
        data class RedditPostData(
            val kind: String,
            val data: RedditPost
        ) {
            data class RedditPost(
                val author: String,
                val title: String,
                val selftext: String,
                val url: String,
                val created: Long
            )
        }
    }
}






