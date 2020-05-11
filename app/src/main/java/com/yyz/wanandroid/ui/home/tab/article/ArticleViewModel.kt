package com.yyz.wanandroid.ui.home.tab.article

import androidx.lifecycle.*
import androidx.paging.PagedList
import com.yyz.wanandroid.common.Event
import com.yyz.wanandroid.data.bean.Data

/**
 * @author yyz (杨云召)
 * @date   2020/4/7
 * time   9:50
 * description
 */
class ArticleViewModel(private val repository: ArticleRepository) : ViewModel() {
    private val request = MutableLiveData<Event<Any>>()

    val articleList: LiveData<PagedList<Data>> = request.switchMap {
        repository.getHomeArticleList()

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