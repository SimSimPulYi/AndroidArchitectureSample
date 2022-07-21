package com.saehyun.feature_notice.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saehyun.domain.exception.NoInternetException
import com.saehyun.domain.exception.UnknownException
import com.saehyun.domain.extention.onFailure
import com.saehyun.domain.extention.onLoading
import com.saehyun.domain.extention.onSuccess
import com.saehyun.domain.usecase.fetch.FetchNoticeUseCase
import com.saehyun.feature_notice.mvi.NoticeMainSideEffect
import com.saehyun.feature_notice.mvi.NoticeMainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class NoticeMainVM @Inject constructor(
    private val fetchNoticeUseCase: FetchNoticeUseCase
) : ContainerHost<NoticeMainState, NoticeMainSideEffect>, ViewModel() {

    override val container = container<NoticeMainState, NoticeMainSideEffect>(NoticeMainState())

    fun fetchPost() = intent {
        loading(true)

        fetchNoticeUseCase()
            .onSuccess {
                reduce { state.copy(notices = it) }
                postSideEffect(NoticeMainSideEffect.FetchNoticeSuccess)
            }
            .onFailure {
                when (it) {
                    is NoInternetException -> {
                        failed(it.message)
                    }
                    is UnknownException -> {
                        failed(it.message)
                    }
                }
            }
            .onLoading {
                loading(false)
            }
            .launchIn(viewModelScope)
    }

    fun changeColorTheme() = intent {
        reduce { state.copy(darkTheme = !state.darkTheme) }
    }

    private fun failed(message: String) = intent {
        postSideEffect(NoticeMainSideEffect.FetchNoticeFailed(message = message))
    }

    private fun loading(isLoading: Boolean) = intent {
        reduce { state.copy(isLoading = isLoading) }
    }
}