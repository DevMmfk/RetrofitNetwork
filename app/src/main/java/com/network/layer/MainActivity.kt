package com.network.layer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.network.layer.databinding.ActivityMainBinding
import com.network.layer.models.login.LoginModel
import com.network.layer.models.login.UserModel
import com.network.layer.viewModel.NewViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: NewViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(NewViewModel::class.java)

        viewModel.responseLiveData1.observe(this, {
            val model = viewModel.convertJsonStringToObject(it, UserModel::class.java)
            binding.textView2.text = model.user.email
        })


        viewModel.responseLiveData2.observe(this, {
            val model = viewModel.convertJsonStringToObject(it, LoginModel::class.java)
            binding.textView3.text = model.user.name
        })
    }

    fun onClick(view: View) {
        viewModel.login(this)
        viewModel.getProfile(this)
        viewModel.deleteP(this)
    }
}