package com.saehyun.remote.mapper

import com.saehyun.core_data.model.FetchNoticeData
import com.saehyun.remote.response.FetchNoticeResponse

fun FetchNoticeResponse.toData(): FetchNoticeData =
    FetchNoticeData(userId, id, title, body)