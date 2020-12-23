package com.example.android_kotlin_mvvm.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.android_kotlin_mvvm.R
import com.example.android_kotlin_mvvm.api.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CurrentWeatherActivity : AppCompatActivity() {
    private lateinit var retrofitService: RetrofitService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_weather)

        fetchCurrentWeather()
    }

    private fun fetchCurrentWeather() {

        retrofitService = RetrofitService.create()

        retrofitService.fetchCurrentWeather("London", "9e79702348d6328424e5d313c699a80e")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe ({ result ->
                Log.d("Result", "${result}")
            }, {
                    error -> error.printStackTrace()
            })
    }
}