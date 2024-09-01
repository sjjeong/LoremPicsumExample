package com.dino.lorempicsumexample.remote.module.api

import com.dino.lorempicsumexample.remote.api.PicsumApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object PicsumApiModule {

    @Provides
    fun providePicsumApi(retrofit: Retrofit): PicsumApi {
        return retrofit.create<PicsumApi>()
    }
}
