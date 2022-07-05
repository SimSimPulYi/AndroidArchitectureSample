package com.saehyun.core_data.mapper

interface EntityMapper<Domain, Data> {
  fun mapToDomain(entity: Data): Domain

  fun mapToData(model: Domain): Data
}
