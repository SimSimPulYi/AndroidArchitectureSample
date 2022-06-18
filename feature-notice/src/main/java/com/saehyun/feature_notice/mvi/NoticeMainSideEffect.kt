package com.saehyun.feature_notice.mvi

sealed class NoticeMainSideEffect {

    object FetchNoticeSuccess: NoticeMainSideEffect()

    object FetchNoticeFailed: NoticeMainSideEffect()
}
