package com.dino.core.data.repository

import androidx.paging.PagingData
import com.dino.core.data.model.PicsumPhotoDto
import kotlinx.coroutines.flow.Flow

interface PicsumRepository {
    fun getPhotosPaging(): Flow<PagingData<PicsumPhotoDto>>
}
