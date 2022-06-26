package com.saehyun.core_data.repository

import com.saehyun.core_data.local.NoticeLocalDataSource
import com.saehyun.core_data.remote.datasource.NoticeRemoteDataSource
import com.saehyun.core_domain.model.FetchNoticeEntity
import com.saehyun.core_domain.repository.NoticeRepository
import javax.inject.Inject

class NoticeRepositoryImpl @Inject constructor(
    private val remoteDataSource: NoticeRemoteDataSource
): NoticeRepository {
    override suspend fun fetchNotice(): FetchNoticeEntity {
        TODO("Not yet implemented")
    }

}