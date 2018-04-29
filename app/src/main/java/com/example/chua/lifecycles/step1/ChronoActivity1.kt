package com.example.chua.lifecycles.step1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Chronometer
import com.example.chua.lifecycles.R

class ChronoActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chronometer = findViewById<Chronometer>(R.id.chronometer)

        chronometer.start()
    }
}