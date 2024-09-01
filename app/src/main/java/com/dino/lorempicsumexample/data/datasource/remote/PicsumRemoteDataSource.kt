package com.dino.lorempicsumexample.data.datasource.remote

import com.dino.lorempicsumexample.data.model.PicsumPhotoDto

interface PicsumRemoteDataSource {
    suspend fun getPhotos(page: Int, limit: Int): Pair<List<PicsumPhotoDto>, Boolean>
}
