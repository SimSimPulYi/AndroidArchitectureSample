package com.saehyun.remote.datasource

import com.saehyun.core_data.model.FetchNoticeData
import com.saehyun.core_data.remote.datasource.NoticeRemoteDataSource
import com.saehyun.remote.api.NoticeAPI
import com.saehyun.domain.exception.NoInternetException
import com.saehyun.remote.mapper.toData
import java.net.UnknownHostException
import javax.inject.Inject

class NoticeRemoteDataSourceImpl @Inject constructor(
    private val noticeAPI: NoticeAPI
): NoticeRemoteDataSource {
    override suspend fun fetchNotices(): List<FetchNoticeData> {
        return try {
            noticeAPI.fetchPosts().map { it.toData() }
        } catch (e: UnknownHostException) {
            throw NoInternetException()
        }
    }
}