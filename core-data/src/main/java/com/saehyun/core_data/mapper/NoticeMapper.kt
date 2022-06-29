package com.saehyun.core_data.mapper

import com.saehyun.core_data.remote.response.PostResponse
import com.saehyun.core_domain.model.FetchNoticeEntity
import javax.inject.Inject

class NoticeMapper @Inject constructor(
): EntityMapper<PostResponse, FetchNoticeEntity> {
    override fun mapToDomain(entity: FetchNoticeEntity): PostResponse {
        return PostResponse(
            userId = entity.userId,
            id = entity.id,
            title = entity.title,
            body = entity.body
        )
    }

    override fun mapToData(model: PostResponse): FetchNoticeEntity {
        return FetchNoticeEntity(
            userId = model.userId,
            id = model.id,
            title = model.title,
            body = model.body
        )
    }
}