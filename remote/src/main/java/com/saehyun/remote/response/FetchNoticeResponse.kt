package com.saehyun.remote.response

import com.google.gson.annotations.SerializedName

data class FetchNoticeResponse(
    @field:SerializedName("userId") val userId: Int,
    @field:SerializedName("id") val id: Int,
    @field:SerializedName("title") val title: String,
    @field:SerializedName("body") val body: String
)