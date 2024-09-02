package com.dino.core.local.module.datasource

import com.dino.core.data.datasource.local.PicsumLocalDataSource
import com.dino.core.local.datasource.PicsumLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface PicsumLocalDataSourceModule {

    @Binds
    @Singleton
    fun bindPicsumLocalDataSource(impl: PicsumLocalDataSourceImpl): PicsumLocalDataSource
}
