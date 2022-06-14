package com.saehyun.feature_auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.saehyun.core_navigator.SampleRoute
import com.saehyun.core_navigator.SampleScreen
import com.saehyun.feature_auth.screen.AuthMainScreen

fun NavGraphBuilder.authNavigation(
    composeNavigator: NavController
) {
    navigation(
        startDestination = SampleScreen.Auth.AUTH_MAIN,
        route = SampleRoute.Auth.name
    ) {
        composable(SampleScreen.Auth.AUTH_MAIN) {
            AuthMainScreen(composeNavigator = composeNavigator)
        }
    }
}