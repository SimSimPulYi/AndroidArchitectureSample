package com.saehyun.feature_auth.mvi

data class AuthMainState(
    val username: String = "",
    val password: String = "",
    val loginBtnEnabled: Boolean = false
)