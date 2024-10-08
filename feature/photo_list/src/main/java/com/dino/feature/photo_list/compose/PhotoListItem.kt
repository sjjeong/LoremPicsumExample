package com.dino.feature.photo_list.compose

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dino.feature.photo_list.model.PhotoModel

@Composable
fun PhotoListItem(
    item: PhotoModel,
    onPhotoClick: (PhotoModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.padding(8.dp),
        onClick = { onPhotoClick(item) },
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(item.width.toFloat() / item.height)
                .align(Alignment.CenterHorizontally),
            model = item.imageUrl,
            contentDescription = "",
        )
    }
}
