package services.vego.network.layer

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import okhttp3.ResponseBody
import services.vego.network.Initialize
import services.vego.network.utilities.ApiServices
import services.vego.network.utilities.ErrorResponse

open class BaseNetwork(url: String) : ViewModel() {

    var apiServices: ApiServices= Initialize(url).provideRetrofit()
    var responseLiveData = MutableLiveData<ResponseBody>()


    fun getData(url:String) {
        apiServices.getData(url).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                if (response.isSuccessful) {
                    responseLiveData.postValue(response.body())
                } else {
                    checkErrorBody(response.errorBody())
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                onFailureApi(t.toString(), "addDevice")
            }
        })
    }


    fun checkErrorBody(errorBody: ResponseBody?) {
        try {
            val gson = Gson()
            val type = object : TypeToken<ErrorResponse>() {}.type
            val errorResponse: ErrorResponse? = gson.fromJson(errorBody!!.charStream(), type)
            Log.e("Network Lib", errorResponse!!.message)
        } catch (e: Exception) {
            Log.e("Network Lib", "Can't format error Json")
        }
    }


    fun onFailureApi(error: String, messageLog: String) {
        Log.e("Network Lib", error)

    }
}