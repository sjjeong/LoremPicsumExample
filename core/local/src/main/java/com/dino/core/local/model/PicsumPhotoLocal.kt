package com.dino.core.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dino.core.data.model.PicsumPhotoDto

@Entity
data class PicsumPhotoLocal(
    @PrimaryKey
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    @ColumnInfo(name = "download_url")
    val downloadUrl: String,
)

fun PicsumPhotoDto.toLocal() = PicsumPhotoLocal(
    id = id,
    author = author,
    width = width,
    height = height,
    url = url,
    downloadUrl = downloadUrl,
)

fun PicsumPhotoLocal.toDto() = PicsumPhotoDto(
    id = id,
    author = author,
    width = width,
    height = height,
    url = url,
    downloadUrl = downloadUrl,
)
