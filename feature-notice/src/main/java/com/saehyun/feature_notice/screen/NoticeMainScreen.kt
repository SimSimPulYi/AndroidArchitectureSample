package com.saehyun.feature_notice.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.rememberNavController
import com.saehyun.common_design.theme.SampleTheme
import com.saehyun.common_design.theme.primaryBlue
import com.saehyun.feature_notice.vm.NoticeMainVM

@Composable
fun NoticeMainScreen(
    composeNavigator: NavController,
    noticeMainVM: NoticeMainVM
) {
    SampleTheme(darkTheme = false) {
        Column(modifier = Modifier.fillMaxSize().background(primaryBlue)) {

        }
    }
}

@Preview
@Composable
fun PreviewNoticeMainScreen() {
    NoticeMainScreen(rememberNavController(), NoticeMainVM())
}