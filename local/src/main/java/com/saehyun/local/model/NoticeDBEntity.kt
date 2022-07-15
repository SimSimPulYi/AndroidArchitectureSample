package com.saehyun.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.saehyun.core_data.model.FetchNoticeData

@Entity(tableName = "noticeDBEntity")
data class NoticeDBEntity(
    @PrimaryKey(autoGenerate = true) val key: Int = 0,
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

fun NoticeDBEntity.toData(): FetchNoticeData =
    FetchNoticeData(
        userId, id, title, body
    )

fun FetchNoticeData.toDbEntity(): NoticeDBEntity =
    NoticeDBEntity(
        userId = userId,
        id = id,
        title = title,
        body = body
    )