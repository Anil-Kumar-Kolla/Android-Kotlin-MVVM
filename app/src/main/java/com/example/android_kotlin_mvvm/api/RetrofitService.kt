package com.example.android_kotlin_mvvm.api

import com.example.android_kotlin_mvvm.models.Response
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET(ApiConstants.CURRENT_WEATHER)
    fun fetchCurrentWeather(@Query("q") query: String, @Query("appid") page: String): Observable<Response>

    @GET(ApiConstants.FORECAST_WEATHER)
    fun fetchForecastWeather(@Query("q") query: String, @Query("appid") page: String = ApiConstants.API_KEY): Observable<Response>




    /**
     * Companion object to create the ApiService
     */
    companion object Factory {
        fun create(): RetrofitService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiConstants.BASE_URL)
                .build()

            return retrofit.create(RetrofitService::class.java);
        }
    }
}
