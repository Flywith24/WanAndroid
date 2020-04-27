package com.yyz.wanandroid.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers

fun <T, A> resultLiveData(
    databaseQuery: () -> LiveData<T>,
    networkCall: suspend () -> RequestState<A>,
    saveCallResult: suspend (A?) -> Unit
): StatefulLiveData<T> =
    liveData(Dispatchers.IO) {
        emit(RequestState.Loading)
        val source =
            databaseQuery.invoke().map { RequestState.Success(data = it) as RequestState<T> }

        emitSource(source)

        when (val responseStatus = networkCall.invoke()) {
            is RequestState.Success -> saveCallResult(responseStatus.data)
            else -> {
                emit(RequestState.NetworkError)
                emitSource(source)
            }
        }
    }