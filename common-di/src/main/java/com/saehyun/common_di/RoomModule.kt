package com.saehyun.common_di

import android.content.Context
import androidx.room.Room
import com.saehyun.core_data.local.NoticeDao
import com.saehyun.core_data.local.NoticesTypeConverter
import com.saehyun.core_data.local.SampleDataBase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun provideWalkHubDatabase(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): SampleDataBase = Room
        .databaseBuilder(context, SampleDataBase::class.java, "SampleDataBase")
        .addTypeConverter(NoticesTypeConverter(moshi))
        .build()

    @Provides
    fun provideNoticeDao(
        sampleDataBase: SampleDataBase
    ): NoticeDao = sampleDataBase.noticeDao()
}