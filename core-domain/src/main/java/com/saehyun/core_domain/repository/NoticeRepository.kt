package com.saehyun.core_domain.repository

import com.saehyun.core_domain.model.FetchNoticeEntity

interface NoticeRepository {
    suspend fun fetchNotice(): List<FetchNoticeEntity>
}