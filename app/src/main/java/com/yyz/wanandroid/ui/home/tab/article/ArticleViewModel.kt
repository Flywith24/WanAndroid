package com.yyz.wanandroid.ui.home.tab.article

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.switchMap
import com.yyz.wanandroid.common.Event

/**
 * @author yyz (杨云召)
 * @date   2020/4/7
 * time   9:50
 * description
 */
class ArticleViewModel(private val repository: ArticleRepository) : ViewModel() {
    private val request = MutableLiveData<Event<Any>>()

    val articleList = request.switchMap {
        repository.getHomeArticleList1()
    }

    fun getHomeArticleList() {
        request.value = Event(Unit)
    }

    @Suppress("UNCHECKED_CAST")
    class ArticleViewModelFactory(
        private val repository: ArticleRepository
    ) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ArticleViewModel(repository) as T
        }
    }
}