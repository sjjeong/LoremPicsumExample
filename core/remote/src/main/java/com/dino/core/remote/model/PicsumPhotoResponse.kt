package com.dino.core.remote.model

import com.dino.core.data.model.PicsumPhotoDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PicsumPhotoResponse(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    @SerialName("download_url")
    val downloadUrl: String,
)

fun PicsumPhotoResponse.toDto(): PicsumPhotoDto {
    return PicsumPhotoDto(
        id = id,
        author = author,
        width = width,
        height = height,
        url = url,
        downloadUrl = downloadUrl
    )
}
