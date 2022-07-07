package com.saehyun.core_data.local

import com.saehyun.core_domain.model.FetchNoticeEntity
import javax.inject.Inject

class NoticeLocalDataSourceImpl @Inject constructor(
    private val noticeDao: NoticeDao
): NoticeLocalDataSource {
    override suspend fun fetchPost(): List<NoticeDBEntity> {
       return noticeDao.fetchNotice()
    }

    override suspend fun updatePost(entity: List<NoticeDBEntity>) {
        noticeDao.updateNotice(entity)
    }
}