package com.saehyun.core_data.remote.api

import com.saehyun.core_data.remote.response.PostResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface NoticeAPI {
    @GET("posts")
    suspend fun fetchPosts(): List<PostResponse>
}