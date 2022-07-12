package com.saehyun.feature_notice.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.saehyun.core_navigator.SampleRoute
import com.saehyun.core_navigator.SampleScreen
import com.saehyun.feature_notice.screen.NoticeMainScreen

fun NavGraphBuilder.noticeNavigation(
    composeNavigator: NavController
) {
    navigation(
        startDestination = SampleScreen.Notice.NOTICE_MAIN,
        route = SampleRoute.Notice.name
    ) {
        composable(SampleScreen.Notice.NOTICE_MAIN) {
            NoticeMainScreen(composeNavigator = composeNavigator, hiltViewModel())
        }
    }
}
