package com.saehyun.feature_notice.mvi

import com.saehyun.core_domain.model.FetchNoticeEntity

data class NoticeMainState(
    val isLoading: Boolean = false,
    val darkTheme: Boolean = false,
    val notices: List<FetchNoticeEntity> = listOf()
)
