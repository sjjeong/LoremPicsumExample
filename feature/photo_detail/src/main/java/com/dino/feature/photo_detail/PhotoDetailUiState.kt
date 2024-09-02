package com.dino.feature.photo_detail

import com.dino.feature.photo_detail.model.PhotoDetailModel

sealed interface PhotoDetailUiState {
    data object Loading : PhotoDetailUiState
    data class Found(val photoDetail: PhotoDetailModel) : PhotoDetailUiState
    data object NotFound : PhotoDetailUiState
}
