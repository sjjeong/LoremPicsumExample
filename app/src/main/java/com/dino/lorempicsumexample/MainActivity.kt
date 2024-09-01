package com.dino.lorempicsumexample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.dino.lorempicsumexample.feature.photo_list.PhotoListActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, PhotoListActivity::class.java))
        finish()
    }
}

