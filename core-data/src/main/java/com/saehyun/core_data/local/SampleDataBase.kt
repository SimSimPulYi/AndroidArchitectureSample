package com.saehyun.core_data.local

import androidx.room.*

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