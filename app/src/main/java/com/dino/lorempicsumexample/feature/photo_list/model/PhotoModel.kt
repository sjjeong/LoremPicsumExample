package com.dino.lorempicsumexample.feature.photo_list.model

import com.dino.lorempicsumexample.data.model.PicsumPhotoDto

data class PhotoModel(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val imageUrl: String,
)

fun PicsumPhotoDto.toUiModel(): PhotoModel {
    return PhotoModel(
        id = id,
        author = author,
        width = width,
        height = height,
        url = url,
        imageUrl = downloadUrl
    )
}
