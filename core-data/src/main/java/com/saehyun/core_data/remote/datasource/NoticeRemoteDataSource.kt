package com.saehyun.core_data.remote.datasource

import com.saehyun.core_data.remote.response.PostResponse
import kotlinx.coroutines.flow.Flow

interface NoticeRemoteDataSource {
    suspend fun fetchPosts(): Flow<PostResponse>
}