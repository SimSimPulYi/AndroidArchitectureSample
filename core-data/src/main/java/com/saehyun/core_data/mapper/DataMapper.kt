package com.saehyun.core_data.mapper

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface DataMapper<DomainModel> {
    fun toDomain(): DomainModel
}

fun <EntityModel, DomainModel> Flow<EntityModel>.toDomain(): Flow<DomainModel> {
    return map { it.toDomainModel<EntityModel, DomainModel>() }
}

fun <EntityModel, DomainModel> EntityModel.toDomainModel(): DomainModel {
    @Suppress("UNCKECKED_CAST")
    return toDomainModel()
    // TODO("Mapper Logic 구현하기")
//    return when (this) {
//        is DataMapper<*> -> toDomain()
//        is List<*> -> map {
//            val domainModel: DomainModel = it.toDomainModel()
//            domainModel
//        }
//        is Unit -> this
//        is
//    }

}
