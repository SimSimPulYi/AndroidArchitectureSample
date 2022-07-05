package com.saehyun.core_data.mapper

import com.saehyun.core_data.local.NoticeDBEntity
import com.saehyun.core_data.remote.response.PostResponse
import com.saehyun.core_domain.model.FetchNoticeEntity
import javax.inject.Inject

class NoticeRemoteMapper @Inject constructor(): EntityMapper<FetchNoticeEntity, PostResponse> {
    override fun mapToDomain(entity: PostResponse): FetchNoticeEntity {
        return FetchNoticeEntity(entity.userId, entity.id, entity.title, entity.body)
    }

    override fun mapToData(model: FetchNoticeEntity): PostResponse {
        return PostResponse(model.userId, model.id, model.title, model.body)
    }
}

class NoticeLocalMapper @Inject constructor(): LocalMapper<NoticeDBEntity, FetchNoticeEntity> {
    override fun mapToDBEntity(entity: FetchNoticeEntity): NoticeDBEntity {
        return NoticeDBEntity(
            userId = entity.userId,
            id = entity.id,
            title = entity.title,
            body = entity.body
        )
    }

    override fun mapToEntity(model: NoticeDBEntity): FetchNoticeEntity {
        return FetchNoticeEntity(
            userId = model.userId,
            id = model.id,
            title = model.title,
            body = model.body
        )
    }
}