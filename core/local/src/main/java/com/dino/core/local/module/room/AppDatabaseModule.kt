package com.dino.core.local.module.room

import android.content.Context
import androidx.room.Room
import com.dino.core.local.dao.PicsumPhotoDao
import com.dino.core.local.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext applicationContext: Context): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "lorem-picsum-room"
        ).build()
    }

    @Provides
    @Singleton
    fun providePicsumPhotoDao(appDatabase: AppDatabase): PicsumPhotoDao {
        return appDatabase.picsumPhotoDao()
    }
}
