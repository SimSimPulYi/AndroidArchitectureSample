package com.saehyun.core_data.mapper

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.map

interface LocalMapper<DataModel> {
    fun toData(): DataModel
}

fun <LocalModel : LocalMapper<DataModel>, DataModel> Flow<LocalModel>.toData(): Flow<DataModel> {
    return map { it.toData() }
}