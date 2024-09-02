package com.dino.core.remote.datasource

import com.dino.core.data.datasource.remote.PicsumRemoteDataSource
import com.dino.core.data.model.PicsumPhotoDto
import com.dino.core.remote.api.PicsumApi
import com.dino.core.remote.model.toDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PicsumRemoteDataSourceImpl @Inject constructor(
    private val picsumApi: PicsumApi,
) : PicsumRemoteDataSource {
    override suspend fun getPhotos(page: Int, limit: Int): Pair<List<PicsumPhotoDto>, Boolean> {
        return withContext(Dispatchers.IO) {
            val response = picsumApi.getPhotos(page = page, limit = limit)
            val hasNext = response.headers()["link"]?.contains("next") ?: false
            val items = (response.body() ?: emptyList()).map { it.toDto() }
            items to hasNext
        }
    }
}
