package com.saehyun.remote.api

import com.saehyun.remote.response.FetchNoticeResponse
import retrofit2.http.GET

interface NoticeAPI {
    @GET("posts")
    fun fetchPosts(): List<FetchNoticeResponse>
}