package com.saehyun.core_data.model

import com.saehyun.domain.model.FetchNoticeEntity

data class FetchNoticeData(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

fun FetchNoticeData.toEntity(): FetchNoticeEntity =
    FetchNoticeEntity(
        userId, id, title, body
    )

fun FetchNoticeEntity.toData(): FetchNoticeData =
    FetchNoticeData(
        userId, id, title, body
    )