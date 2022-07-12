package com.saehyun.local.database

import androidx.room.*
import com.saehyun.local.model.NoticeDBEntity
import com.saehyun.local.dao.NoticeDao

@Database(
    entities = [
        NoticeDBEntity::class
    ],
    version = 1
)

@TypeConverters()

abstract class SampleDataBase : RoomDatabase() {
    abstract fun noticeDao(): NoticeDao
}