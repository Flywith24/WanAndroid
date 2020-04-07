package com.yyz.wanandroid.data.api

import com.yyz.myapplication.data.Friend
import com.yyz.myapplication.data.HomeBanner
import com.yyz.wanandroid.data.bean.Article
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author yyz (杨云召)
 * @date   2020-02-06
 * time   22:30
 * description
 */

const val BASE_URL = "https://www.wanandroid.com/"

interface CommonService {

    /*首页文章列表*/
    @GET("article/list/{pageSize}/json")
    suspend fun getHomeArticleList(@Path("pageSize") pageSize: Int): Response<Article>

    /*首页项目列表*/
    @GET("article/listproject/{pageSize}/json")
    suspend fun getProjectList(@Path("pageSize") pageSize: Int): Response<Article>

    /*首页banner*/
    @GET("banner/json")
    suspend fun getHomeBanner(): Response<List<HomeBanner>>

    /*常用网站*/
    @GET("friend/json")
    suspend fun friend(): Response<List<Friend>>
}