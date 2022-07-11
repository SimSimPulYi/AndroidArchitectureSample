package com.saehyun.feature_notice.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saehyun.core_domain.base.Result
import com.saehyun.core_domain.exception.NoInternetException
import com.saehyun.core_domain.exception.UnknownException
import com.saehyun.core_domain.usecase.fetch.FetchNoticeUseCase
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
            .onEach { result ->
                when (result) {
                    is Result.Loading -> {
                        loading(false)
                    }

                    is Result.Success -> {
                        reduce { state.copy(notices = result.value) }
                        postSideEffect(NoticeMainSideEffect.FetchNoticeSuccess)
                    }

                    is Result.Failure -> {
                        result.throwable.let {
                            when (it) {
                                is NoInternetException -> {
                                    failed(it.message)
                                }
                                is UnknownException -> {
                                    failed(it.message)
                                }
                            }
                        }
                    }
                }
            }.launchIn(viewModelScope)
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