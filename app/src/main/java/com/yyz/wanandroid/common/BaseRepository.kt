package com.yyz.wanandroid.common


import com.yyz.wanandroid.data.api.Response
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

/**
 * @author yyz (杨云召)
 * @date   2020-02-22
 * time   15:44
 * description
 */

/**
 * 使用协程网络请求处理异常
 */
suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> Response<T>
): RequestState<T> {
    return withContext(dispatcher) {
        try {
            val response = apiCall.invoke()
            if ("0" == response.errorCode) RequestState.Success(response.data)
            else RequestState.GenericError(
                response.errorCode,
                ApiException(response.errorMsg, code = response.errorCode)
            )
        } catch (throwable: Throwable) {
            formatError(throwable)
        }
    }
}


private fun formatError(throwable: Throwable): RequestState<Nothing> {
    return when (throwable) {
        is IOException -> RequestState.NetworkError
        is HttpException -> {
            val code = throwable.code()
            val errorResponse = convertErrorBody(throwable)
            RequestState.GenericError(code.toString(), errorResponse)
        }
        else -> {
            RequestState.GenericError(null, null)
        }
    }
}

private fun convertErrorBody(throwable: HttpException): ApiException? {
    return try {
        ApiException("网络错误", throwable, "HTTP_ERROR")
    } catch (exception: Exception) {
        null
    }
}