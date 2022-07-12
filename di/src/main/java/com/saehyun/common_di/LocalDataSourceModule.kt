package com.saehyun.common_di

import com.saehyun.core_data.local.NoticeLocalDataSource
import com.saehyun.local.datasource.NoticeLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Singleton
    @Binds
    abstract fun providesLocalNoticeRepository(
        noticeLocalDataSourceImpl: NoticeLocalDataSourceImpl
    ): NoticeLocalDataSource
}