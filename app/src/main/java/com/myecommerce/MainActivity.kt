package com.myecommerce

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.myecommerce.base.ui.Notifier
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Notifier.init(this)
    }
}