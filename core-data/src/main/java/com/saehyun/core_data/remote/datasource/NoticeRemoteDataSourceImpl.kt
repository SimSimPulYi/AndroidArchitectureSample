package com.saehyun.core_data.remote.datasource

import com.saehyun.core_data.remote.api.NoticeAPI
import com.saehyun.core_data.remote.response.PostResponse
import com.saehyun.core_domain.exception.NoInternetException
import com.saehyun.core_domain.exception.UnknownException
import kotlinx.coroutines.flow.Flow
import java.lang.Exception
import java.net.UnknownHostException
import javax.inject.Inject

class NoticeRemoteDataSourceImpl @Inject constructor(
    private val noticeAPI: NoticeAPI
): NoticeRemoteDataSource  {
    override suspend fun fetchPosts(): List<PostResponse> {
        return try {
            noticeAPI.fetchPosts()
        } catch (e: UnknownHostException) {
            throw NoInternetException()
        }
    }
}