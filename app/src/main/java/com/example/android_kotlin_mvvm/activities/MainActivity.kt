package com.example.android_kotlin_mvvm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android_kotlin_mvvm.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == button1.id) {
            val intent = Intent(this, CurrentWeatherActivity::class.java)
            startActivity(intent)

        } else {
            val intent = Intent(this, ForeCastActivity::class.java)
            startActivity(intent)
        }
    }
}