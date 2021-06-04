package com.example.weather

import android.content.ContentProviderClient
import android.content.Intent
import android.location.LocationProvider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

import java.sql.ClientInfoStatus

class MainActivity : AppCompatActivity() {
    private lateinit var btnEnter: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEnter = findViewById(R.id.btnEnter)
        btnEnter.setOnClickListener {
            var intent = Intent(baseContext,   Readings::class.java)
            startActivity(intent)
        }

    }
}





