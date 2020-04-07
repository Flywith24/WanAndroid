package com.yyz.wanandroid.ui.home.tab.article

import com.yyz.wanandroid.common.BaseRepository
import com.yyz.wanandroid.common.StatefulLiveData
import com.yyz.wanandroid.data.api.RetrofitClient
import com.yyz.wanandroid.data.bean.Data
import com.yyz.wanandroid.ui.home.tab.ArticleDao
import resultLiveData

/**
 * @author yyz (杨云召)
 * @date   2020/4/7
 * time   9:51
 * description
 */
class ArticleRepository(private val articleDao: ArticleDao) : BaseRepository() {

    fun getHomeArticleList(pageSize: Int = 0): StatefulLiveData<List<Data>> = resultLiveData(
        databaseQuery = { articleDao.loadAllArticles() },
        networkCall = {
            safeApiCall { RetrofitClient.api.getHomeArticleList(pageSize) }
        },
        saveCallResult = { data ->
            data?.datas?.let {
                articleDao.insertArticles(it)
            }
        })

    companion object {
        @Volatile
        private var instance: ArticleRepository? = null

        fun getInstance(articleDao: ArticleDao) = instance
            ?: synchronized(this) {
                instance
                    ?: ArticleRepository(articleDao).also { instance = it }
            }
    }
}