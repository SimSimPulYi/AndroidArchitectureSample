package com.saehyun.feature_auth.screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saehyun.common_base.observeWithLifecycle
import com.saehyun.common_design.component.SampleTextField
import com.saehyun.common_design.component.YellowButton
import com.saehyun.common_design.theme.Body1
import com.saehyun.common_design.theme.SampleTheme
import com.saehyun.core_navigator.SampleScreen
import com.saehyun.feature_auth.mvi.AuthMainSideEffect
import com.saehyun.feature_auth.vm.AuthMainVM
import kotlinx.coroutines.InternalCoroutinesApi

@OptIn(InternalCoroutinesApi::class)
@Composable
fun AuthMainScreen(
    composeNavigator: NavController,
    authMainVM: AuthMainVM
) {
    val authMainContainer = authMainVM.container
    val authMainState = authMainContainer.stateFlow.collectAsState().value
    val authMainSideEffect = authMainContainer.sideEffectFlow

    authMainSideEffect.observeWithLifecycle {
        when(it) {
            is AuthMainSideEffect.IntentNotice -> {
                composeNavigator.navigate(SampleScreen.Notice.NOTICE_MAIN) {
                    launchSingleTop = true
                }
            }
        }
    }

    SampleTheme(darkTheme = false) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(120.dp))

            Body1(text = "로그인")

            Spacer(modifier = Modifier.height(30.dp))

            SampleTextField(value = authMainState.username, onValueChange = { authMainVM.inputUsername(it)} )

            Spacer(modifier = Modifier.height(16.dp))

            SampleTextField(value = authMainState.password, onValueChange = { authMainVM.inputPassword(it) } )

            Spacer(modifier = Modifier.height(20.dp))

            YellowButton(text = "LOGIN", enabled = authMainState.loginBtnEnabled, onClick = { authMainVM.intentAuth() })
        }
    }
}

@Preview
@Composable
fun PreviewAuthMainScreen() {
    AuthMainScreen(rememberNavController(), hiltViewModel())
}