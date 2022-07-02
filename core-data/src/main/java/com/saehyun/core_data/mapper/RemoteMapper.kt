package com.saehyun.core_data.mapper

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface RemoteMapper<DataModel> {
    fun toData(): DataModel
}

fun <RemoteModel : RemoteMapper<DataModel>, DataModel> Flow<RemoteModel>.toData(): Flow<DataModel> {
    return map { it.toData() }
}