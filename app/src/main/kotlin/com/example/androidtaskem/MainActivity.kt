package com.example.androidtaskem

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtaskem.screens.FirstFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setStartScreen(FirstFragment())
    }
}


