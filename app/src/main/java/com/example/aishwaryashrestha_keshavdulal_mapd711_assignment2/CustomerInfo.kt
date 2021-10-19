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
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CustomerInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_info)

        // Collect data from intent object
        val intent = intent
        val bookedCruise = intent.getStringExtra("bookedCruise")
        val totalGuests = intent.getStringExtra("totalGuests")
        val totalPrice = intent.getStringExtra("totalPrice")
        val duration = intent.getStringExtra("duration")

        // Store EditText field's references
        val fullNameET = findViewById<EditText>(R.id.fullNameET)
        val addressET = findViewById<EditText>(R.id.addressET)
        val cityET = findViewById<EditText>(R.id.cityET)
        val countryET = findViewById<EditText>(R.id.countryET)
        val postalCodeET = findViewById<EditText>(R.id.postalCodeET)
        val telephoneET = findViewById<EditText>(R.id.telephoneET)
        val emailET = findViewById<EditText>(R.id.emailET)

        // Locate Send button
        val reserveBtn = findViewById<Button>(R.id.customerInfoSubmitBtn)

        // Add clickListener to button
        reserveBtn.setOnClickListener {
            // collect data from EditText field's references stored above
            val fullName = fullNameET.text.toString()
            val address = addressET.text.toString()
            val city = cityET.text.toString()
            val country = countryET.text.toString()
            val postalCode = postalCodeET.text.toString()
            val telephone = telephoneET.text.toString()
            val email = emailET.text.toString()


            // Initialize intent object to pass data
            val myIntentObject = Intent(this@CustomerInfo, BookingConfirmation::class.java)

            // Store user inputs in the newly created intent object
            myIntentObject.putExtra("fullName", fullName)
            myIntentObject.putExtra("address", address)
            myIntentObject.putExtra("city", city)
            myIntentObject.putExtra("country", country)
            myIntentObject.putExtra("postalCode", postalCode)
            myIntentObject.putExtra("telephone", telephone)
            myIntentObject.putExtra("email", email)

            // from previous activity screen
            myIntentObject.putExtra("bookedCruise", bookedCruise)
            myIntentObject.putExtra("totalGuests", totalGuests)
            myIntentObject.putExtra("totalPrice", totalPrice)
            myIntentObject.putExtra("duration", duration)

            // Send intent object to  SecondActivity
            startActivity(myIntentObject)
        }
    }
}
