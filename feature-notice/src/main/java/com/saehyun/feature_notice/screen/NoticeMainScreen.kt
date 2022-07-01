package com.saehyun.feature_notice.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saehyun.common_base.observeWithLifecycle
import com.saehyun.common_design.icon.SampleIcons
import com.saehyun.common_design.theme.Body1
import com.saehyun.common_design.theme.Body2
import com.saehyun.common_design.theme.SampleTheme
import com.saehyun.feature_notice.mvi.NoticeMainSideEffect
import com.saehyun.feature_notice.vm.NoticeMainVM
import kotlinx.coroutines.InternalCoroutinesApi

@OptIn(InternalCoroutinesApi::class)
@Composable
fun NoticeMainScreen(
    composeNavigator: NavController,
    noticeMainVM: NoticeMainVM
) {

    val noticeMainContainer = noticeMainVM.container
    val noticeMainState = noticeMainContainer.stateFlow.collectAsState().value
    val noticeMainSideEffect = noticeMainContainer.sideEffectFlow

    val context = LocalContext.current

    noticeMainSideEffect.observeWithLifecycle {
        when (it) {
            is NoticeMainSideEffect.FetchNoticeSuccess -> {}
            is NoticeMainSideEffect.FetchNoticeFailed -> {
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    SampleTheme(darkTheme = noticeMainState.darkTheme) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            noticeMainVM.fetchPost()

            if (noticeMainState.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }

            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)) {
                items(items = noticeMainState.notices, itemContent = { item ->
                    Notice(title = item.title, content = item.body)
                })
            }

            IconButton(
                onClick = { noticeMainVM.changeColorTheme() },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 20.dp, end = 20.dp)
            ) {
                Image(
                    painter = painterResource(
                        id = if (noticeMainState.darkTheme) SampleIcons.Moon else SampleIcons.Sun
                    ), contentDescription = stringResource(
                        id = if (noticeMainState.darkTheme) com.saehyun.common_design.R.string.dark_mode else
                            com.saehyun.common_design.R.string.light_mode
                    )
                )
            }
        }
    }
}

@Composable
fun Notice(title: String, content: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(15.dp))

        Body1(text = title, color = MaterialTheme.colors.onBackground)

        Spacer(modifier = Modifier.height(10.dp))

        Body2(text = content, color = MaterialTheme.colors.onBackground)

        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Preview
@Composable
fun NoticeMainPreview() {
    NoticeMainScreen(composeNavigator = rememberNavController(), noticeMainVM = hiltViewModel())
}