package services.vego.network.layer

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import services.vego.network.Constants
import services.vego.network.Initialize
import services.vego.network.ViewDialog
import services.vego.network.utilities.ApiServices
import services.vego.network.utilities.ErrorResponse

open class BaseNetwork(mApplication: Application, url: String) : AndroidViewModel(mApplication) {

    var apiServices: ApiServices = Initialize(url).provideRetrofit()

    open fun showDialog(context: Context) {
        if (Constants.dialog == null) {
            Constants.dialog = ViewDialog.CreateViewDialog(context)
        }
        if (Constants.dialog!!.isShowing)
            Constants.dialog!!.dismiss()
        Constants.dialog!!.show()
    }

    open fun hideDialog() {
        if (Constants.dialog != null) {
            if (Constants.dialog!!.isShowing)
                Constants.dialog!!.dismiss()
        }
        Constants.dialog = null
    }


    fun getData(url: String, responseLiveData: MutableLiveData<String>) {
        apiServices.getData(url).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                hideDialog()
                if (response.isSuccessful) {
                    responseLiveData.postValue(response.body()!!.string())
                } else {
                    checkErrorBody(response.errorBody())
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                hideDialog()
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

    fun <T> convertJsonStringToObject(jsonString: String, clazz: Class<T>): T {
        val gson = Gson()
        val objectList = gson.fromJson(jsonString, clazz)
        return objectList
    }
}