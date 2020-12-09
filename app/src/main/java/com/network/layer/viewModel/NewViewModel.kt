package com.network.layer.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import services.vego.network.layer.BaseNetwork

class NewViewModel(application: Application) : BaseNetwork(application, "https://api.wattak.com") {
    var responseLiveData1 = MutableLiveData<String>()
    var responseLiveData2 = MutableLiveData<String>()
    var responseLiveData3 = MutableLiveData<String>()
    fun getCars(context: Context) {
        showDialog(context)
        getData("/cars/v1/cars", responseLiveData1)
    }

    fun getFollowingCars(context: Context) {
        showDialog(context)
        getData("/cars/v1/most/followed", responseLiveData2)
    }
}