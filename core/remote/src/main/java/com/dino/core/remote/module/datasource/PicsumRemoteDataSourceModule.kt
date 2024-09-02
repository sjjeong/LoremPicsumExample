package com.dino.core.remote.module.datasource

import com.dino.core.data.datasource.remote.PicsumRemoteDataSource
import com.dino.core.remote.datasource.PicsumRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface PicsumRemoteDataSourceModule {

    @Binds
    @Singleton
    fun providePicsumRemoteDataSource(
        picsumRemoteDataSourceImpl: PicsumRemoteDataSourceImpl,
    ): PicsumRemoteDataSource
}
