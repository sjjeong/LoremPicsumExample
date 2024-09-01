package com.dino.lorempicsumexample.data.repository

import androidx.paging.PagingData
import com.dino.lorempicsumexample.data.model.PicsumPhotoDto
import kotlinx.coroutines.flow.Flow

interface PicsumRepository {
    fun getPhotosPaging(): Flow<PagingData<PicsumPhotoDto>>
}
