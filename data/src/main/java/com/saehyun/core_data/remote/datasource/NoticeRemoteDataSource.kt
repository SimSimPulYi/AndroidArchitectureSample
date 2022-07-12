package com.saehyun.core_data.remote.datasource

import com.saehyun.core_data.model.FetchNoticeData

interface NoticeRemoteDataSource {
    suspend fun fetchNotices(): List<FetchNoticeData>
}