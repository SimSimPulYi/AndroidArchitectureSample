package com.saehyun.feature_notice.mvi

sealed class NoticeMainSideEffect {

    object FetchNoticeSuccess : NoticeMainSideEffect()

    data class FetchNoticeFailed(val message: String) : NoticeMainSideEffect()
}
