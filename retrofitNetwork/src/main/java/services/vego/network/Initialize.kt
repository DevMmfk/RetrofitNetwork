package services.vego.network

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import services.vego.network.utilities.ApiServices
import java.util.concurrent.TimeUnit

open class Initialize (private val baseUrl: String){


    fun provideRetrofit(): ApiServices {
        provideRetrofitBuilder()
        return provideRetrofitBuilder().build().create(ApiServices::class.java)
    }

    private fun provideRetrofitBuilder(): Retrofit.Builder {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        provideOkHttpClientInterceptor().addInterceptor(logging)
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(provideOkHttpClientInterceptor().build())
            .baseUrl(baseUrl)
    }


    private fun provideOkHttpClientInterceptor(): OkHttpClient.Builder {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()


        httpClient.addInterceptor(Interceptor { chain ->
            chain.proceed(
                chain.request()
                    .newBuilder()
                    .addHeader("Content-type", "application/json")
                    .addHeader("Accept", "application/json")
                    .build()
            )
        })


        httpClient.readTimeout(60, TimeUnit.SECONDS)
        httpClient.connectTimeout(60, TimeUnit.SECONDS)

        httpClient.addInterceptor(logging)

        return httpClient
    }

}