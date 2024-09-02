package com.dino.feature.photo_detail.model

import com.dino.core.data.model.PicsumPhotoDto

data class PhotoDetailModel(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val imageUrl: String,
)

fun PicsumPhotoDto.toUiModel(): PhotoDetailModel {
    return PhotoDetailModel(
        id = id,
        author = author,
        width = width,
        height = height,
        url = url,
        imageUrl = downloadUrl
    )
}
