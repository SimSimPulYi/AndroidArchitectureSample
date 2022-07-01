package com.saehyun.core_data.remote.datasource

import com.saehyun.core_data.remote.api.NoticeAPI
import com.saehyun.core_data.remote.response.PostResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoticeRemoteDataSourceImpl @Inject constructor(
    private val noticeAPI: NoticeAPI
): NoticeRemoteDataSource  {
    override suspend fun fetchPosts(): List<PostResponse> {
        return noticeAPI.fetchPosts()
    }
}