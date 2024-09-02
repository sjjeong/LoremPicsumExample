package com.dino.lorempicsumexample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.dino.feature.photo_list.PhotoListActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, PhotoListActivity::class.java))
        finish()
    }
}

