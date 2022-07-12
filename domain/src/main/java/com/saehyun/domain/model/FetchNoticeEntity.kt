package com.saehyun.domain.model

data class FetchNoticeEntity(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)