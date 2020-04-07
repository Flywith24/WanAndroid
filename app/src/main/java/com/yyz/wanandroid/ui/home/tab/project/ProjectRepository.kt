package com.yyz.wanandroid.ui.home.tab.project

import androidx.lifecycle.liveData
import com.yyz.wanandroid.common.BaseRepository
import com.yyz.wanandroid.common.StatefulLiveData
import com.yyz.wanandroid.data.api.RetrofitClient
import com.yyz.wanandroid.data.bean.Article

/**
 * @author yyz (杨云召)
 * @date   2020/4/7
 * time   11:26
 * description
 */
class ProjectRepository private constructor() : BaseRepository() {

    fun getProjectList(pageSize: Int = 0): StatefulLiveData<Article> {
        return liveData {
            emit(safeApiCall { RetrofitClient.api.getProjectList(pageSize) })
        }
    }

    companion object {
        @Volatile
        private var instance: ProjectRepository? = null

        fun getInstance() = instance
            ?: synchronized(this) {
                instance
                    ?: ProjectRepository().also { instance = it }
            }
    }
}