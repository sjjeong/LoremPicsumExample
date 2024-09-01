package com.dino.lorempicsumexample.feature.photo_list

import androidx.compose.runtime.Composable
import com.dino.lorempicsumexample.base.BaseComposeActivity
import com.dino.lorempicsumexample.feature.photo_list.compose.PhotoListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoListActivity : BaseComposeActivity() {
    override val content: @Composable () -> Unit = {
        PhotoListScreen()
    }
}
