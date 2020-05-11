package com.yyz.wanandroid.ui.home.tab.article

import android.util.Log
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.liveData
import androidx.paging.PagedList
import com.yyz.wanandroid.common.pagingResult
import com.yyz.wanandroid.common.resultLiveData
import com.yyz.wanandroid.common.safeApiCall
import com.yyz.wanandroid.data.api.RetrofitClient
import com.yyz.wanandroid.data.bean.Article
import com.yyz.wanandroid.data.bean.Data
import com.yyz.wanandroid.ui.home.tab.ArticleDao
import com.yyz.wanandroid.ui.home.tab.article.ArticleRepository.Companion.PAGE_SIZE
import kotlinx.coroutines.launch

/**
 * @author yyz (杨云召)
 * @date   2020/4/8
 * time   9:45
 * description
 */
class ArticleBoundaryCallback(
    private val lifecycleScope: LifecycleCoroutineScope,
    private val dao: ArticleDao
) : PagedList.BoundaryCallback<Data>() {

    override fun onZeroItemsLoaded() {
        pagingResult(
            lifecycleScope,
            networkCall = { networkCall(0) },
            saveCallResult = { result -> saveResult(result) })
    }

    override fun onItemAtEndLoaded(itemAtEnd: Data) {
        Log.i(TAG, "onItemAtEndLoaded: itemAtEnd ${itemAtEnd.indexInResponse} ")
        val pageSize = (itemAtEnd.indexInResponse) / PAGE_SIZE
        Log.i(TAG, "onItemAtEndLoaded: $pageSize")
        pagingResult(
            lifecycleScope,
            networkCall = { networkCall(pageSize) },
            saveCallResult = { result -> saveResult(result) })
    }

    /**
     * 保存网络请求结果
     */
    private suspend fun saveResult(result: Article?) {
        if (result != null) {
            dao.insertArticles(result.datas)
        }
    }

    /**
     * 网络请求
     */
    private suspend fun networkCall(pageSize: Int) =
        safeApiCall { RetrofitClient.api.getHomeArticleList(pageSize) }

    companion object {
        private const val TAG = "ArticleBoundaryCallback"
    }
}