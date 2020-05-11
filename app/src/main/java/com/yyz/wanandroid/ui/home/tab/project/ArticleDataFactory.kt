package com.yyz.wanandroid.ui.home.tab.project

import androidx.lifecycle.liveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.yyz.wanandroid.common.safeApiCall
import com.yyz.wanandroid.data.api.RetrofitClient
import com.yyz.wanandroid.data.bean.Data

/**
 * @author yyz (杨云召)
 * @date   2020/5/11
 * time   10:46
 * description
 */
/*
class ArticleDataFactory : DataSource.Factory<Int, Data>() {
    override fun create(): DataSource<Int, Data> {

    }
}

class ArticleDataSource() : PageKeyedDataSource<Int, Data>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Data>
    ) {
        liveData {
            val result = safeApiCall { RetrofitClient.api.getProjectList(0) }
            emit(null)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Data>) {
        TODO("Not yet implemented")
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Data>) {
        TODO("Not yet implemented")
    }

}*/
