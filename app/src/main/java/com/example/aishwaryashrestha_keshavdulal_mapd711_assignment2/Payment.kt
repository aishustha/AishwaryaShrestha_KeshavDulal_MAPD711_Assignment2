/**
 * Student Id       : 301209947, 301138662
 * Student Name     : Keshav Dulal, Aishwarya Shrestha
 * Course           : MAPD 711 - Samsung Android App Development
 * Submission Date  : 10/18/2021
 * Exercise Number  : A2 - Cruise Booking App
 */

package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        // Locate Continue Button
        val continueBtn = findViewById<Button>(R.id.paymentDetailsContinueBtn)

        // Reference Form fields
        val cardNumberET = findViewById<EditText>(R.id.cardNumberET)
        val cardExpiryET = findViewById<EditText>(R.id.cardExpiryET)
        val cardTypeET = findViewById<EditText>(R.id.cardTypeET)

        // Collect data from intent object
        val intent = intent
        val destination = intent.getStringExtra("destination")
        val totalGuests = intent.getStringExtra("totalGuests")
        val totalPrice = intent.getStringExtra("totalPrice")


        // Add clickListener to button
        continueBtn.setOnClickListener {

            // collect data forms
            val cardNumber = cardNumberET.text?.toString()
            val cardExpiry = cardExpiryET.text?.toString()
            val cardType = cardTypeET.text?.toString()

            // Initialize intent object to pass data
            val myIntentObject = Intent(this@payment, CustomerInfo::class.java)
            // todo: remove these 3
            myIntentObject.putExtra("cardNumber", cardNumber)
            myIntentObject.putExtra("cardExpiry", cardExpiry)
            myIntentObject.putExtra("cardType", cardType)

            myIntentObject.putExtra("destination", destination)
            myIntentObject.putExtra("totalGuests", totalGuests)
            myIntentObject.putExtra("totalPrice", totalPrice)

            // Send intent object to TravellersCounter Activity
            startActivity(myIntentObject)
        }
    }
}