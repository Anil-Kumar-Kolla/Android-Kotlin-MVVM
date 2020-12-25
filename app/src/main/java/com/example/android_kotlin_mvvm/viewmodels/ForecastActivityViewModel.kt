package com.example.android_kotlin_mvvm.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_kotlin_mvvm.api.ApiConstants
import com.example.android_kotlin_mvvm.api.RetrofitService
import com.example.android_kotlin_mvvm.models.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ForecastActivityViewModel : ViewModel() {
    private lateinit var retrofitService: RetrofitService

    val response: MutableLiveData<Response> by lazy {
        MutableLiveData<Response>()
    }

    fun fetchCurrentWeather() {
        retrofitService = RetrofitService.create()

        retrofitService.fetchForecastWeather("London, India", ApiConstants.API_KEY)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe ({ result ->
                Log.d("Result", "${result}")
                response.postValue(result)
            }, {
                    error -> error.printStackTrace()
            })
    }
}