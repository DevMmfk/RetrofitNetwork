package com.network.layer.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import services.vego.network.layer.BaseNetwork

class NewViewModel(application: Application) : BaseNetwork(application) {
    var responseLiveData1 = MutableLiveData<String>()
    var responseLiveData2 = MutableLiveData<String>()
    var deleteLiveData = MutableLiveData<String>()

    fun getProfile(context: Context) {
        showDialog(context)
        getData("...", responseLiveData1)
    }

    fun login(context: Context) {
        showDialog(context)
        val map = HashMap<String, String>()
        map["username"] = "+962"
        map["password"] = "1234"
        map["device_token"] = "JRb90yWlsQQ7BaQtOrO869F5KXAtEVw5A3fZ8Pn7gBA_OVjcJvT1WLpxD3YoPHJwvN_GhEV47rKADxLqp84_qUkNqleb6AU1tOxhu_aVhN"
        getData("...", map, responseLiveData2)
    }

    fun deleteP(context: Context) {
        showDialog(context)
        deleteApi("....", deleteLiveData)
    }
}