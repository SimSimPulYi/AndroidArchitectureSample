package com.saehyun.core_data.local

import com.saehyun.core_data.model.FetchNoticeData

interface NoticeLocalDataSource {
    suspend fun fetchNotices(): List<FetchNoticeData>
    suspend fun updatePost(entity: List<FetchNoticeData>)
}