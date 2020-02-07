package com.yyz.wanandroid.data.api

/**
 * @author yyz (杨云召)
 * @date   2020-02-06
 * time   22:32
 * description
 */
data class Response<T>(
    var data: T?,
    var errorCode: String,
    var errorMsg: String
)