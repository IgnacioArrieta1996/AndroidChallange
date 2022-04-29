package com.example.challangeandroid.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.challangeandroid.R
import com.example.challangeandroid.databinding.ActivityMainBinding
import com.highquality.base.presenter.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}