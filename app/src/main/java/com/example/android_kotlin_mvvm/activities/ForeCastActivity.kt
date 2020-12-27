package com.example.android_kotlin_mvvm.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android_kotlin_mvvm.R
import com.example.android_kotlin_mvvm.models.Response
import com.example.android_kotlin_mvvm.viewmodels.ForecastActivityViewModel
import kotlinx.android.synthetic.main.activity_forecast.*

class ForeCastActivity : AppCompatActivity() {
    private lateinit var viewModel: ForecastActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        setupViewModel()
        observeData()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this).get(ForecastActivityViewModel::class.java)
        viewModel.fetchCurrentWeather()
    }

    private fun observeData() {
        val responseObserver = Observer<Response> { response ->
            response_text.text = "RESPONSE ---> " + response
        }

        viewModel.response.observe(this, responseObserver)
    }
}