package com.saehyun.common_di

import com.saehyun.core_data.remote.datasource.NoticeRemoteDataSource
import com.saehyun.remote.datasource.NoticeRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Singleton
    @Binds
    abstract fun providesRemoteNoticeRepository(
        noticeRemoteDataSourceImpl: NoticeRemoteDataSourceImpl
    ): NoticeRemoteDataSource
}