package com.saehyun.feature_notice.vm

import androidx.lifecycle.ViewModel
import com.saehyun.core_domain.usecase.fetch.FetchNoticeUseCase
import com.saehyun.feature_notice.mvi.NoticeMainSideEffect
import com.saehyun.feature_notice.mvi.NoticeMainState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class NoticeMainVM @Inject constructor(
    private val fetchNoticeUseCase: FetchNoticeUseCase
): ContainerHost<NoticeMainState, NoticeMainSideEffect>, ViewModel() {

    override val container = container<NoticeMainState, NoticeMainSideEffect>(NoticeMainState())

     fun fetchPost() = intent {
        loading(true)
        fetchNoticeUseCase.perform()
            .onSuccess {
                reduce { state.copy(notices = it) }
                postSideEffect(NoticeMainSideEffect.FetchNoticeSuccess)
            }
            .onFailure {
                postSideEffect(NoticeMainSideEffect.FetchNoticeFailed(message = "error!"))
            }
            .also {
                loading(false)
            }
    }

    fun changeColorTheme() = intent {
        reduce { state.copy(darkTheme = !state.darkTheme) }
    }

    private fun loading(isLoading: Boolean) = intent {
        reduce { state.copy(isLoading = isLoading) }
    }
}