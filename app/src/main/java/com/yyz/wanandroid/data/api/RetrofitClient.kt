package com.yyz.wanandroid.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * @author yyz (杨云召)
 * @date   2020-01-31
 * time   22:46
 * description
 */
object RetrofitClient {

    val api: CommonService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return@lazy retrofit.create<CommonService>()
    }
}