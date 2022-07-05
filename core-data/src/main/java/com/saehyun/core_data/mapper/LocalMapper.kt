package com.saehyun.core_data.mapper

interface LocalMapper<Domain, Data> {
  fun mapToDBEntity(entity: Data): Domain

  fun mapToEntity(model: Domain): Data
}
