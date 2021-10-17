package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sendBtn = findViewById<Button>(R.id.sendBtn)

        //handle button click
        sendBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)

            //sending data to second activity
            startActivity(intent)
        }
    }
}