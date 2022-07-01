package com.saehyun.core_domain.mapper

interface EntityMapper<Presentation, Domain> {
  fun mapToPresentation(entity: Domain): Presentation

  fun mapToDomain(model: Presentation): Domain
}
