package com.saehyun.local.datasource

import com.saehyun.core_data.local.NoticeLocalDataSource
import com.saehyun.core_data.model.FetchNoticeData
import com.saehyun.local.model.NoticeDBEntity
import com.saehyun.local.dao.NoticeDao
import com.saehyun.local.model.toData
import com.saehyun.local.model.toDbEntity
import javax.inject.Inject

class NoticeLocalDataSourceImpl @Inject constructor(
    private val noticeDao: NoticeDao
): NoticeLocalDataSource {
    override suspend fun fetchNotices(): List<FetchNoticeData> {
       return noticeDao.fetchNotice().map { it.toData() }
    }

    override suspend fun updatePost(entity: List<FetchNoticeData>) {
        noticeDao.updateNotice(entity.map { it.toDbEntity() })
    }
}