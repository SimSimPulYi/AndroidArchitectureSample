package com.saehyun.core_domain.usecase.fetch

import com.saehyun.core_domain.model.FetchNoticeEntity
import com.saehyun.core_domain.repository.NoticeRepository
import com.saehyun.core_domain.usecase.BaseUseCase
import javax.inject.Inject

class FetchNoticeUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
): BaseUseCase<Result<List<FetchNoticeEntity>>, Unit> {
    override suspend fun perform(): Result<List<FetchNoticeEntity>> =
        kotlin.runCatching {
            noticeRepository.fetchNotice()
        }
}
