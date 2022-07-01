package com.saehyun.core_data.repository

import com.saehyun.core_data.mapper.NoticeMapper
import com.saehyun.core_data.remote.datasource.NoticeRemoteDataSource
import com.saehyun.core_domain.model.FetchNoticeEntity
import com.saehyun.core_domain.repository.NoticeRepository
import javax.inject.Inject
import javax.inject.Singleton

class NoticeRepositoryImpl @Inject constructor(
    private val noticeMapper: NoticeMapper,
    private val remoteDataSource: NoticeRemoteDataSource
): NoticeRepository {
    override suspend fun fetchNotice(): List<FetchNoticeEntity> {
        return remoteDataSource.fetchPosts().map {
            noticeMapper.mapToDomain(it)
        }
    }
}