package com.yyz.wanandroid.common


/**
 * @author yyz (杨云召)
 * @date   2020/2/25
 * time   10:16
 * description
 */
sealed class RequestState<out T> {
    object Loading : RequestState<Nothing>()
    data class Success<out T>(val data: T?) : RequestState<T>()
    data class GenericError(val code: String? = null, val error: ApiException? = null) : RequestState<Nothing>()
    object NetworkError : RequestState<Nothing>()
}