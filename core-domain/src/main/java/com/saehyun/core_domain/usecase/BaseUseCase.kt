package com.saehyun.core_domain.usecase

import kotlinx.coroutines.flow.Flow

interface BaseUseCase<out Result, in ExecutableParam> {

  suspend fun perform(): Result = throw NotImplementedError()

  suspend fun perform(params: ExecutableParam): Result? = throw NotImplementedError()

  fun performStreaming(params: ExecutableParam?): Flow<Result> = throw NotImplementedError()
}
