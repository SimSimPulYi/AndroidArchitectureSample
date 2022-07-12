package com.saehyun.core_navigator

sealed class SampleScreen(val route: String) {
    object Auth : SampleScreen("Auth") {
        const val AUTH_MAIN = "AUTH_MAIN"
    }

    object Notice : SampleScreen("Notice") {
        const val NOTICE_MAIN = "NOTICE_MAIN"
    }
}

sealed class SampleRoute(val name: String) {
    object Auth : SampleRoute("auth")
    object Notice : SampleRoute("notice")
}

