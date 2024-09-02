package com.dino.core.data.datasource.local

import com.dino.core.data.model.PicsumPhotoDto

interface PicsumLocalDataSource {
    suspend fun getPhoto(id: String): PicsumPhotoDto?
    suspend fun savePhotos(photos: List<PicsumPhotoDto>)
    suspend fun savePhoto(photo: PicsumPhotoDto)
}
