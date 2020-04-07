package com.yyz.wanandroid.ui.home.tab

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yyz.wanandroid.data.bean.Data

/**
 * @author yyz (杨云召)
 * @date   2020/4/7
 * time   11:59
 * description
 */

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: List<Data>)

    @Query("SELECT * FROM data")
    fun loadAllArticles(): LiveData<List<Data>>
}