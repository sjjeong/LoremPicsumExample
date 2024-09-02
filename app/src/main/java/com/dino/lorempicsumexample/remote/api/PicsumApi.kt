package com.dino.lorempicsumexample.remote.api

import com.dino.lorempicsumexample.remote.model.PicsumPhotoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PicsumApi {

    @GET("/v2/list")
    suspend fun getPhotos(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
    ): Response<List<PicsumPhotoResponse>>
}
