package com.saehyun.domain.repository

import com.saehyun.domain.model.FetchNoticeEntity
import kotlinx.coroutines.flow.Flow

interface NoticeRepository {
    suspend fun fetchNotice(): Flow<List<FetchNoticeEntity>>
}