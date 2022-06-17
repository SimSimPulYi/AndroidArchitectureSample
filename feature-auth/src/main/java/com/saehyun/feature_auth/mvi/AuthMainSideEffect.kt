package com.saehyun.feature_auth.mvi

sealed class AuthMainSideEffect {
    object IntentNotice: AuthMainSideEffect()
}
