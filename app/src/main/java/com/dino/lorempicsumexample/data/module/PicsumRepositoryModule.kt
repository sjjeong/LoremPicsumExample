package com.dino.lorempicsumexample.data.module

import com.dino.lorempicsumexample.data.repository.PicsumRepository
import com.dino.lorempicsumexample.data.repository.PicsumRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface PicsumRepositoryModule {

    @Binds
    @Singleton
    fun bindPicsumRepository(
        picsumRepositoryImpl: PicsumRepositoryImpl,
    ): PicsumRepository
}
