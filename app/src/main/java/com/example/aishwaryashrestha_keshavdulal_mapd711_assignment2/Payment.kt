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

class payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        // Locate Continue Button
        val continueBtn = findViewById<Button>(R.id.paymentDetailsContinueBtn)

        // Collect data from intent object
        val intent = intent
        val bookedCruise = intent.getStringExtra("bookedCruise")
        val totalGuests = intent.getStringExtra("totalGuests")
        val totalPrice = intent.getStringExtra("totalPrice")
        val duration = intent.getStringExtra("duration")

        // Add clickListener to button
        continueBtn.setOnClickListener {

            // Initialize intent object to pass data
//            val myIntentObject = Intent(this@payment, CustomerInfo::class.java)
            val myIntentObject = Intent(this@payment, BookingConfirmation::class.java)


//            aishwaryashrestha222@gmail.com
            // Store user inputs in the newly created intent object
//            myIntentObject.putExtra("fullName", fullName)
//            myIntentObject.putExtra("address", address)
//            myIntentObject.putExtra("city", city)
//            myIntentObject.putExtra("country", country)
//            myIntentObject.putExtra("postalCode", postalCode)
//            myIntentObject.putExtra("telephone", telephone)
//            myIntentObject.putExtra("email", email)

            myIntentObject.putExtra("bookedCruise", bookedCruise)
            myIntentObject.putExtra("totalGuests", totalGuests)
            myIntentObject.putExtra("totalPrice", totalPrice)
            myIntentObject.putExtra("duration", duration)

            // Send intent object to TravellersCounter Activity
            startActivity(myIntentObject)
        }
    }
}
