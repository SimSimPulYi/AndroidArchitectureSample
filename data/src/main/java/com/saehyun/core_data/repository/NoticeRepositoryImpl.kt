package com.saehyun.core_data.repository

import com.saehyun.core_data.local.NoticeLocalDataSource
import com.saehyun.core_data.model.toData
import com.saehyun.core_data.model.toEntity
import com.saehyun.core_data.remote.datasource.NoticeRemoteDataSource
import com.saehyun.core_data.utils.OfflineCacheUtil
import com.saehyun.domain.model.FetchNoticeEntity
import com.saehyun.domain.repository.NoticeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoticeRepositoryImpl @Inject constructor(
    private val remoteNoticeDataSource: NoticeRemoteDataSource,
    private val localNoticeDataSource: NoticeLocalDataSource
) : NoticeRepository {

    override suspend fun fetchNotice(): Flow<List<FetchNoticeEntity>> {
        return OfflineCacheUtil<List<FetchNoticeEntity>>()
            .remoteData { remoteNoticeDataSource.fetchNotices().map { it.toEntity() } }
            .localData { localNoticeDataSource.fetchNotices().map { it.toEntity() } }
            .doOnNeedRefresh { localNoticeDataSource.updatePost( it.map { it.toData() } ) }
            .createFlow()
    }
}