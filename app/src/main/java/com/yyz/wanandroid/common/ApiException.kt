package com.yyz.wanandroid.common

/**
 * @author yyz (杨云召)
 * @date   2020/4/7
 * time   9:54
 * description
 */
@Suppress("UNUSED_PARAMETER")
class ApiException(msg: String?, throwable: Throwable? = null, code: String? = "") : Exception(msg, throwable) {

    constructor(throwable: Throwable? = null, code: String = "") : this("", throwable, code)
}