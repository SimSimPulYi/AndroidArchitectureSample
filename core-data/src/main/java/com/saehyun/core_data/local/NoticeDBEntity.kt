package com.saehyun.core_data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "noticeDBEntity")
data class NoticeDBEntity(
    @PrimaryKey (autoGenerate = true) val key: Int = 0,
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)