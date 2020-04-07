package com.yyz.wanandroid.ui.home.tab.project

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.switchMap
import com.yyz.wanandroid.common.Event

/**
 * @author yyz (杨云召)
 * @date   2020/4/7
 * time   11:25
 * description
 */
class ProjectViewModel(private val repository: ProjectRepository) : ViewModel() {
    private val request = MutableLiveData<Event<Any>>()
    val projectList = request.switchMap {
        repository.getProjectList()
    }
    fun getProjectList() {
        request.value = Event(Unit)
    }

    @Suppress("UNCHECKED_CAST")
    class ArticleViewModelFactory(
        private val repository: ProjectRepository
    ) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ProjectViewModel(repository) as T
        }
    }
}