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
    var audit: Int,
    var author: String?,
    var canEdit: Boolean,
    var chapterId: Int,
    var chapterName: String?,
    var collect: Boolean,
    var courseId: Int,
    var desc: String?,
    var descMd: String?,
    var envelopePic: String?,
    var fresh: Boolean,
    @PrimaryKey
    var id: Int,
    var link: String?,
    var niceDate: String?,
    var niceShareDate: String?,
    var origin: String?,
    var prefix: String?,
    var projectLink: String?,
    var publishTime: Long,
    var selfVisible: Int,
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
    constructor() : this(
        "", 0, "", false, 0, "", false, 0
        , "", "", "", false, 0, "", "", "", ""
        , "", "", 0L, 0, 0L, "", 0, "",
        emptyList<Tag>(), "", 0, 0, 0, 0
    )
}

data class Tag(
    val name: String,
    val url: String
)