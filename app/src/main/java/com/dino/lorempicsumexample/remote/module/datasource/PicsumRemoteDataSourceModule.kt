package com.dino.lorempicsumexample.remote.module.datasource

import com.dino.lorempicsumexample.data.datasource.remote.PicsumRemoteDataSource
import com.dino.lorempicsumexample.remote.datasource.PicsumRemoteDataSourceImpl
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
