package com.saehyun.core_data.local

import com.saehyun.core_domain.model.FetchNoticeEntity

interface NoticeLocalDataSource {
    suspend fun fetchPost(): List<NoticeDBEntity>
    suspend fun updatePost(entity: List<NoticeDBEntity>)
}