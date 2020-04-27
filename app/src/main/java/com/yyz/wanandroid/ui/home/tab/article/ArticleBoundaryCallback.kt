package com.yyz.wanandroid.ui.home.tab.article

import androidx.paging.PagedList
import com.yyz.wanandroid.data.bean.Data

/**
 * @author yyz (杨云召)
 * @date   2020/4/8
 * time   9:45
 * description
 */
class ArticleBoundaryCallback : PagedList.BoundaryCallback<Data>() {
    override fun onZeroItemsLoaded() {

    }

    override fun onItemAtEndLoaded(itemAtEnd: Data) {
        super.onItemAtEndLoaded(itemAtEnd)
    }

    override fun onItemAtFrontLoaded(itemAtFront: Data) {
        super.onItemAtFrontLoaded(itemAtFront)
    }
}