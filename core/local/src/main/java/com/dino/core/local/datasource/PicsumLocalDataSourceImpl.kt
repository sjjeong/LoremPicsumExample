package com.dino.core.local.datasource

import com.dino.core.data.datasource.local.PicsumLocalDataSource
import com.dino.core.data.model.PicsumPhotoDto
import com.dino.core.local.dao.PicsumPhotoDao
import com.dino.core.local.model.toDto
import com.dino.core.local.model.toLocal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PicsumLocalDataSourceImpl @Inject constructor(
    private val picsumPhotoDao: PicsumPhotoDao,
) : PicsumLocalDataSource {
    override suspend fun getPhoto(id: String): PicsumPhotoDto? {
        return withContext(Dispatchers.IO) {
            picsumPhotoDao.getPicsumPhoto(id)?.toDto()
        }
    }

    override suspend fun savePhotos(photos: List<PicsumPhotoDto>) {
        withContext(Dispatchers.IO) {
            picsumPhotoDao.insertAll(photos.map { it.toLocal() })
        }
    }

    override suspend fun savePhoto(photo: PicsumPhotoDto) {
        withContext(Dispatchers.IO) {
            picsumPhotoDao.insert(photo.toLocal())
        }
    }
}
