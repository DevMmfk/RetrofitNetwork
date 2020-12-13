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
        getData("users/v1/me", responseLiveData1)
    }

    fun login(context: Context) {
        showDialog(context)
        val map = HashMap<String, String>()
        map["grant_type"] = "password"
        map["client_id"] = "2"
        map["client_secret"] = "gPENEIiNCCoFnFi9ibom1tdDRZblznIjmEa8bbZu"
        map["username"] = "+962786184866"
        map["password"] = "1234"
        map["device_token"] = "f1c2tbZ6RL6adoMvDkndOQ:APA91bGUstdb-nmsmjqmN0Gn3KMEw9iFBLJRb90yWlsQQ7BaQtOrO869F5KXAtEVw5A3fZ8Pn7gBA_OVjcJvT1WLpxD3YoPHJwvN_GhEV47rKADxLqp84_qUkNqleb6AU1tOxhu_aVhN"
        getData("users/v1/oauth/token", map, responseLiveData2)
    }

    fun deleteP(context: Context) {
        showDialog(context)
        deleteApi("stores/v1/products/17", deleteLiveData)
    }
}