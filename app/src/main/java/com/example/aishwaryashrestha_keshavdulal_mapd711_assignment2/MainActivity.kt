/**
 * Student Id       : 301209947, 301138662
 * Student Name     : Keshav Dulal, Aishwarya Shrestha
 * Course           : MAPD 711 - Samsung Android App Development
 * Submission Date  : 10/18/2021
 * Exercise Number  : A2 - Cruise Booking App
 */

package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val signinBtn= findViewById<Button>(R.id.signinBtn)
        val registerBtn = findViewById<Button>(R.id.registerBtn)

        //starts service to play background music
        Intent(this,BackgroundMusic::class.java).also {
            startService(it)
        }

        //handle button click
        signinBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, BookingActivity::class.java)

            //sending data to second activity
            startActivity(intent)
        }

        //handle button click
        registerBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, Register::class.java)

            //sending data to second activity
            startActivity(intent)
        }
    }
}
