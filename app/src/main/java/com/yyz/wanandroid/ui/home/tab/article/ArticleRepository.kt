package com.yyz.wanandroid.ui.home.tab.article

import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.yyz.wanandroid.common.StatefulLiveData
import com.yyz.wanandroid.common.resultLiveData
import com.yyz.wanandroid.common.safeApiCall
import com.yyz.wanandroid.data.api.RetrofitClient
import com.yyz.wanandroid.data.bean.Data
import com.yyz.wanandroid.ui.home.tab.ArticleDao

/**
 * @author yyz (杨云召)
 * @date   2020/4/7
 * time   9:51
 * description
 */
class ArticleRepository(
    private val lifecycleScope: LifecycleCoroutineScope,
    private val dao: ArticleDao
) {

    fun getHomeArticleList(pageSize: Int = 0): StatefulLiveData<List<Data>> = resultLiveData(
        databaseQuery = { dao.loadAllArticles() },
        networkCall = { safeApiCall { RetrofitClient.api.getHomeArticleList(pageSize) } },
        saveCallResult = { data -> data?.datas?.let { dao.insertArticles(it) } })

    fun getHomeArticleList(): LiveData<PagedList<Data>> =
        dao.loadArticles()
            .toLiveData(
                PAGE_SIZE,
                boundaryCallback = ArticleBoundaryCallback(lifecycleScope, dao)
            )

    companion object {
        @Volatile
        private var instance: ArticleRepository? = null

        fun getInstance(
            lifecycleScope: LifecycleCoroutineScope,
            articleDao: ArticleDao
        ) = instance
            ?: synchronized(this) {
                instance
                    ?: ArticleRepository(lifecycleScope, articleDao).also { instance = it }
            }

        const val PAGE_SIZE = 20
    }
}