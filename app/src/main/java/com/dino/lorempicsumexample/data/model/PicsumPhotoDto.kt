package com.dino.lorempicsumexample.data.model

data class PicsumPhotoDto(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val downloadUrl: String,
)
