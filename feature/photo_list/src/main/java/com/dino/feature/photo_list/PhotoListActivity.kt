package com.dino.feature.photo_list

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.core.net.toUri
import com.dino.core.ui.base.BaseComposeActivity
import com.dino.feature.photo_list.compose.PhotoListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoListActivity : BaseComposeActivity() {
    override val content: @Composable () -> Unit = {
        PhotoListScreen(
            onPhotoClick = { photo ->
                val uri = "dino://photo/detail".toUri()
                    .buildUpon()
                    .appendQueryParameter("id", photo.id)
                    .build()
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        )
    }
}
