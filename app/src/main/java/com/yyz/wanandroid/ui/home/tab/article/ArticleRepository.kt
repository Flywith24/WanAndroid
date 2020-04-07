package com.yyz.wanandroid.ui.home.tab.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.yyz.wanandroid.common.BaseRepository
import com.yyz.wanandroid.common.RequestState
import com.yyz.wanandroid.data.api.RetrofitClient
import com.yyz.wanandroid.data.bean.Article

/**
 * @author yyz (杨云召)
 * @date   2020/4/7
 * time   9:51
 * description
 */
class ArticleRepository : BaseRepository() {
    fun getHomeArticleList(pageSize: Int = 0): LiveData<RequestState<Article>> {
        return liveData {
            emit(safeApiCall { RetrofitClient.api.getHomeArticleList(pageSize) })
        }
    }

    companion object {
        @Volatile
        private var instance: ArticleRepository? = null

        fun getInstance() = instance
            ?: synchronized(this) {
                instance
                    ?: ArticleRepository().also { instance = it }
            }
    }
}