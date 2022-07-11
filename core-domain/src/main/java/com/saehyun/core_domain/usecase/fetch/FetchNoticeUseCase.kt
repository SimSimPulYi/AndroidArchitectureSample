package com.saehyun.core_domain.usecase.fetch

import android.content.ContentValues.TAG
import android.util.Log
import com.saehyun.core_domain.base.Result
import com.saehyun.core_domain.repository.NoticeRepository
import com.saehyun.core_domain.base.BaseUseCase
import com.saehyun.core_domain.model.FetchNoticeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import java.lang.Exception
import javax.inject.Inject

class FetchNoticeUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
): BaseUseCase<List<FetchNoticeEntity>, Unit> {

    override operator fun invoke() = flow {

        try {
            noticeRepository.fetchNotice().collect {
                emit(Result.Success(it))
            }
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }

        emit(Result.Loading)

    }.flowOn(Dispatchers.IO)
}
