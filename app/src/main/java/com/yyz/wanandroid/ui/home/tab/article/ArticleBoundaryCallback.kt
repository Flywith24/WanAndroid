package com.yyz.wanandroid.ui.home.tab.article

import android.util.Log
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.paging.PagedList
import com.yyz.wanandroid.data.bean.Data
import com.yyz.wanandroid.ui.home.tab.ArticleDao
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
        lifecycleScope.launch {
          /*  val result = Api.create().getHomeArticleList(0).data?.datas
            if (result != null) {
                dao.insertData(data = result)
            }*/
        }
    }

    override fun onItemAtEndLoaded(itemAtEnd: Data) {
       /* lifecycleScope.launch {
            Log.i(TAG, "onItemAtEndLoaded: itemAtEnd ${itemAtEnd.indexInResponse} ")
            val pageSize = (itemAtEnd.indexInResponse) / PAGE_SIZE
            Log.i(TAG, "onItemAtEndLoaded: $pageSize")
            val result =
                Api.create().getHomeArticleList(pageSize).data?.datas
            if (result != null) {
                dao.insertData(data = result)
            }
        }*/
    }

}