package com.dino.feature.photo_detail.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dino.feature.photo_detail.model.PhotoDetailModel

@Composable
fun PhotoDetailFoundScreen(
    photoDetail: PhotoDetailModel,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        Card(
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(photoDetail.width.toFloat() / photoDetail.height)
                    .align(Alignment.CenterHorizontally),
                model = photoDetail.imageUrl,
                contentDescription = "${photoDetail.author}'s photo",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PhotoDetailFoundScreenPreview() {
    PhotoDetailFoundScreen(
        photoDetail = PhotoDetailModel(
            id = "0",
            author = "Alejandro Escamilla",
            width = 5000,
            height = 3333,
            url = "https://unsplash.com/photos/yC-Yzbqy7PY",
            imageUrl = "https://picsum.photos/id/0/5000/3333",
        )
    )
}
