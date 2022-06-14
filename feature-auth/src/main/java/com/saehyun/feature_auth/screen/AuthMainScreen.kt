package com.saehyun.feature_auth.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saehyun.common_design.component.RedButton
import com.saehyun.common_design.theme.SampleTheme
import com.saehyun.core_navigator.SampleScreen

@Composable
fun AuthMainScreen(
    composeNavigator: NavController
) {
    NavController
    SampleTheme(darkTheme = true) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            RedButton(text = "Next Step") {
                composeNavigator.navigate(SampleScreen.Notice.NOTICE_MAIN) {
                    launchSingleTop = true
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewAuthMainScreen() {
    AuthMainScreen(rememberNavController())
}