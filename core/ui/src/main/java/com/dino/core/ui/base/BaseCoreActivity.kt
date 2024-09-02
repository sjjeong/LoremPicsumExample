package com.dino.core.ui.base

import android.os.Bundle
import androidx.activity.ComponentActivity

abstract class BaseCoreActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleDeepLink()
    }

    private fun handleDeepLink() {
        val extras = intent.extras?.deepCopy() ?: Bundle()
        val data = intent.data
        data?.queryParameterNames?.forEach {
            extras.putString(it, data.getQueryParameter(it))
        }
        intent.putExtras(extras)
    }
}
