package com.network.layer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.network.layer.viewModel.NewViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel:NewViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(NewViewModel::class.java)
        viewModel.getCars()
    }
}