package com.saehyun.core_domain.usecase.fetch

import android.content.Context
import com.saehyun.core_domain.model.FetchNoticeEntity
import com.saehyun.core_domain.repository.NoticeRepository
import com.saehyun.core_domain.usecase.BaseUseCase
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class FetchNoticeUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
): BaseUseCase<Result<FetchNoticeEntity>, Unit> {
    override suspend fun perform(): Result<FetchNoticeEntity> =
        kotlin.runCatching {
            noticeRepository.fetchNotice()
        }
}
