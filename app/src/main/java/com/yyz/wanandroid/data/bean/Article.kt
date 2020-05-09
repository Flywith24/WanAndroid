@file:Suppress("SpellCheckingInspection")

package com.yyz.wanandroid.data.bean

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * @author yyz (杨云召)
 * @date   2020-02-06
 * time   22:35
 * description
 */
data class Article(
    val curPage: Int,
    val datas: List<Data>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)

@Entity
data class Data(
    var apkLink: String?,
    var author: String?,
    var collect: Boolean,
    var desc: String?,
    var id: Int,
    var link: String?,
    var niceDate: String?,
    var projectLink: String?,
    var publishTime: Long,
    var shareDate: Long,
    var shareUser: String?,
    var superChapterId: Int,
    var superChapterName: String?,
    @Ignore
    var tags: List<Tag>,
    var title: String?,
    var type: Int,
    var userId: Int,
    var visible: Int,
    var zan: Int
) {
    @PrimaryKey(autoGenerate = true)
    var indexInResponse: Int = -1
}

data class Tag(
    val name: String,
    val url: String
)