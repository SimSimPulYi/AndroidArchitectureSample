package com.saehyun.core_data.mapper

import com.saehyun.core_data.remote.response.PostResponse
import com.saehyun.core_domain.model.FetchNoticeEntity
import javax.inject.Inject

class NoticeMapper @Inject constructor(
): EntityMapper<FetchNoticeEntity, PostResponse> {
    override fun mapToData(model: FetchNoticeEntity): PostResponse {
        return PostResponse(
            userId = model.userId,
            id = model.id,
            title = model.title,
            body = model.body
        )
    }

    override fun mapToDomain(entity: PostResponse): FetchNoticeEntity {
        return FetchNoticeEntity(
            userId = entity.userId,
            id = entity.id,
            title = entity.title,
            body = entity.body
        )
    }
}