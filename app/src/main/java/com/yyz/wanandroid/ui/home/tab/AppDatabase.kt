package com.yyz.wanandroid.ui.home.tab

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yyz.wanandroid.data.bean.Data

/**
 * @author yyz (杨云召)
 * @date   2020/4/7
 * time   11:57
 * description
 */

@Database(entities = [Data::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "data-db")
                .build()
        }
    }
}