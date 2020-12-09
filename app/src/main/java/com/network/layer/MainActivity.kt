package com.network.layer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.network.layer.databinding.ActivityMainBinding
import com.network.layer.models.about.PagesModel
import com.network.layer.models.cars.CarsModel
import com.network.layer.viewModel.NewViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: NewViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(NewViewModel::class.java)
        viewModel.responseLiveData1.observe(this, {
            val model = viewModel.convertJsonStringToObject(it, CarsModel::class.java)
            binding.textView2.text = model.data[0].name
        })

        viewModel.responseLiveData2.observe(this, {
            val model = viewModel.convertJsonStringToObject(it, CarsModel::class.java)
            binding.textView3.text = model.data[0].name
        })

        viewModel.responseLiveData3.observe(this, {
            val model = viewModel.convertJsonStringToObject(it, PagesModel::class.java)
            binding.textView4.text = model.data.content
        })
    }

    fun onClick(view: View) {
        viewModel.getCars(this)
        viewModel.getFollowingCars(this)
    }
}