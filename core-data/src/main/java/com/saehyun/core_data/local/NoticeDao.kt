package com.saehyun.core_data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoticeDao {
    @Query("SELECT * FROM noticeDBEntity")
    suspend fun fetchNotice(): List<NoticeDBEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNotice(notices: List<NoticeDBEntity>)
}