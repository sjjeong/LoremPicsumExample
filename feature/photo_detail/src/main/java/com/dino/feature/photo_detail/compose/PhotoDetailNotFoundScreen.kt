package com.dino.feature.photo_detail.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PhotoDetailNotFoundScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Photo not found")
    }
}

@Preview(showBackground = true)
@Composable
private fun PhotoDetailNotFoundScreenPreview() {
    PhotoDetailNotFoundScreen()
}
