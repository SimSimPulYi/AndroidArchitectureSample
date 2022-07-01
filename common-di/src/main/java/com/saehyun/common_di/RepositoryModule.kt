package com.saehyun.common_di

import com.saehyun.core_data.repository.NoticeRepositoryImpl
import com.saehyun.core_domain.repository.NoticeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun providesNoticeRepository(
        noticeRepositoryImpl: NoticeRepositoryImpl
    ): NoticeRepository
}