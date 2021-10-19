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
import android.view.View
import android.widget.*

class TravellersCounter : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travellers_counter)

        // Collect data from intent object
        val intent = intent
        // Extract values from intent object using relevant keys
        val bookedCruise = intent.getStringExtra("bookedCruise")
        val cruisePrice = intent.getStringExtra("cruisePrice")
        val duration = intent.getStringExtra("duration")

        // Reference Spinner UI
        val adultCounterSpinner: Spinner = findViewById(R.id.adultCounterSpinner)
        val kidCounterSpinner: Spinner = findViewById(R.id.kidCounterSpinner)

        val seniorRadioYes =findViewById<RadioButton>(R.id.adultYesRadioBtn)
        val isSeniorPresent:Boolean = seniorRadioYes.isChecked

        // Locate Continue Button
        val continueBtn = findViewById<Button>(R.id.travellersCountContinueBtn)

        // Add clickListener to button
        continueBtn.setOnClickListener {
        // Extract data from spinners
            val adultCount:String = adultCounterSpinner.selectedItem.toString()
            val kidCount:String = kidCounterSpinner.selectedItem.toString()
            val totalGuests:Int = (adultCount?.toInt()?.let { kidCount?.toInt()?.plus(it) })

            val totalPrice = cruisePrice?.toInt()?.times(totalGuests)

            // Initialize intent object to pass data
            val myIntentObject = Intent(this@TravellersCounter, Summary::class.java)
            myIntentObject.putExtra("totalGuests", totalGuests.toString())
            myIntentObject.putExtra("bookedCruise", bookedCruise)
            myIntentObject.putExtra("totalPrice", totalPrice.toString())
            myIntentObject.putExtra("duration", duration)
//            println("🐞 $totalGuests ${bookedCruise}, ${cruisePrice}, ${duration}")

            // Send intent object to TravellersCounter Activity
            startActivity(myIntentObject)
        }
    }
}