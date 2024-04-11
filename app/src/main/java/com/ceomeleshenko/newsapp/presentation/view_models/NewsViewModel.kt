package com.ceomeleshenko.newsapp.presentation.view_models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ceomeleshenko.newsapp.data.models.News
import com.ceomeleshenko.newsapp.domain.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {

    val selectedNews: MutableLiveData<News> = MutableLiveData()
    var openNewsCounter: MutableLiveData<Int> = MutableLiveData(0)

    val news: LiveData<List<News>> = liveData {
        val news = getNewsUseCase.execute()
        emit(news)
    }

    private val _FeedbackDialog = MutableStateFlow(false)
    val showFeedbackDialog: StateFlow<Boolean> = _FeedbackDialog

    fun showDialog() {
        _FeedbackDialog.value = true
    }

    fun hideDialog() {
        _FeedbackDialog.value = false
    }

    fun selectNews(news: News) {
        clearSelectedNews()
        selectedNews.value = news
        if (openNewsCounter.value!! < 3) {
            openNewsCounter.value = openNewsCounter.value?.plus(1)
        }
        Log.d("TAG", "selectNews: ${openNewsCounter.value}")
    }

    private fun clearSelectedNews() {
        selectedNews.value = News()
    }
}