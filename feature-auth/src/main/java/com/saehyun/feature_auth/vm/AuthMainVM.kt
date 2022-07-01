package com.saehyun.feature_auth.vm

import androidx.lifecycle.ViewModel
import com.saehyun.core_domain.usecase.fetch.FetchNoticeUseCase
import com.saehyun.feature_auth.mvi.AuthMainSideEffect
import com.saehyun.feature_auth.mvi.AuthMainState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class AuthMainVM @Inject constructor(): ContainerHost<AuthMainState, AuthMainSideEffect>, ViewModel() {

    override val container = container<AuthMainState, AuthMainSideEffect>(AuthMainState())

    fun intentAuth() = intent {
        postSideEffect(AuthMainSideEffect.IntentNotice)
    }

    fun inputUsername(username: String) = intent {
        setLoginBtnState()
        reduce { state.copy(username = username) }
    }

    fun inputPassword(password: String) = intent {
        setLoginBtnState()
        reduce { state.copy(password = password) }
    }

    private fun setLoginBtnState() = intent {
        reduce { state.copy(loginBtnEnabled = state.username.isNotEmpty() && state.password.isNotEmpty()) }
    }
}