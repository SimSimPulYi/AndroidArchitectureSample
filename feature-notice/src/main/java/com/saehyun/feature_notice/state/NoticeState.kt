package com.saehyun.feature_notice.state

sealed class NoticeState {
    object Loading : NoticeState()

    data class Success(val noticeState: NoticeState) : NoticeState()

    object Failure : NoticeState()
}