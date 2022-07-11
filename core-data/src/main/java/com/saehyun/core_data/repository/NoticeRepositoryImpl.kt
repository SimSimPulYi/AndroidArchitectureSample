package com.saehyun.core_data.repository

import com.saehyun.core_data.local.NoticeLocalDataSource
import com.saehyun.core_data.mapper.NoticeLocalMapper
import com.saehyun.core_data.mapper.NoticeRemoteMapper
import com.saehyun.core_data.remote.datasource.NoticeRemoteDataSource
import com.saehyun.core_data.utils.OfflineCacheUtil
import com.saehyun.core_domain.model.FetchNoticeEntity
import com.saehyun.core_domain.repository.NoticeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NoticeRepositoryImpl @Inject constructor(
    private val noticeRemoteMapper: NoticeRemoteMapper,
    private val noticeLocalMapper: NoticeLocalMapper,
    private val remoteNoticeDataSource: NoticeRemoteDataSource,
    private val localNoticeDataSource: NoticeLocalDataSource
) : NoticeRepository {

    override suspend fun fetchNotice(): Flow<List<FetchNoticeEntity>> {
        return OfflineCacheUtil<List<FetchNoticeEntity>>()
            .remoteData { remoteNoticeDataSource.fetchPosts().map { noticeRemoteMapper.mapToDomain(it) } }
            .localData { localNoticeDataSource.fetchPost().map { noticeLocalMapper.mapToEntity(it) } }
            .doOnNeedRefresh { localNoticeDataSource.updatePost(it.map { noticeLocalMapper.mapToDBEntity(it) }) }
            .createFlow()
    }
}