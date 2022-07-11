package com.saehyun.core_data.remote.datasource

import com.saehyun.core_data.remote.response.PostResponse

interface NoticeRemoteDataSource {
    suspend fun fetchPosts(): List<PostResponse>
}