package com.saehyun.core_domain.repository

import com.saehyun.core_domain.model.FetchNoticeEntity
import kotlinx.coroutines.flow.Flow

interface NoticeRepository {
    suspend fun fetchNotice(): Flow<List<FetchNoticeEntity>>
}