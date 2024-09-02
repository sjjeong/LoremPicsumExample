package com.dino.core.data.datasource.remote

import com.dino.core.data.model.PicsumPhotoDto

interface PicsumRemoteDataSource {
    suspend fun getPhotos(page: Int, limit: Int): Pair<List<PicsumPhotoDto>, Boolean>
}
