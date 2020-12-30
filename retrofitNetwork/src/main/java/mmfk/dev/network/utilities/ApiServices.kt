package mmfk.dev.network.utilities


import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {

    @GET
    fun getData(
        @HeaderMap headers: Map<String, String>,
        @Url url: String
    ): Call<ResponseBody>


    @FormUrlEncoded
    @POST
    fun postData(
        @HeaderMap headers: Map<String, String>,
        @Url url: String,
        @FieldMap map: HashMap<String, String>
    ): Call<ResponseBody>

    @DELETE
    fun deleteData(
        @HeaderMap headers: Map<String, String>,
        @Url url: String,
    ): Call<ResponseBody>


    @PUT
    fun putData(
        @HeaderMap headers: Map<String, String>,
        @Url url: String,
        @FieldMap map: HashMap<String, String>
    ): Call<ResponseBody>
}