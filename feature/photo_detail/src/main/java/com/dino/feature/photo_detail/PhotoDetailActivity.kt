package com.dino.feature.photo_detail

import androidx.compose.runtime.Composable
import com.dino.core.ui.base.BaseComposeActivity
import com.dino.feature.photo_detail.compose.PhotoDetailScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoDetailActivity : BaseComposeActivity() {
    override val content: @Composable () -> Unit = {
        PhotoDetailScreen()
    }
}
