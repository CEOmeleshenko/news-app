package com.ceomeleshenko.newsapp.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ceomeleshenko.newsapp.data.models.News
import com.ceomeleshenko.newsapp.domain.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
): ViewModel() {
    val news: LiveData<List<News>> = liveData {
        val news = getNewsUseCase.execute()
        emit(news)
    }
}