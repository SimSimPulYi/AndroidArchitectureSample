package com.saehyun.domain.usecase.fetch

import com.saehyun.domain.base.Result
import com.saehyun.domain.repository.NoticeRepository
import com.saehyun.domain.base.BaseUseCase
import com.saehyun.domain.model.FetchNoticeEntity
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
