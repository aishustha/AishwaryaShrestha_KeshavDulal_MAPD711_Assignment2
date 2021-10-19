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
import android.widget.TextView
import org.w3c.dom.Text

class Summary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        // Collect data from intent object
        val intent = intent

        // Extract values from intent object using relevant keys
        val bookedCruise = intent.getStringExtra("bookedCruise")
        val totalGuests = intent.getStringExtra("totalGuests")
        val totalPrice = intent.getStringExtra("totalPrice")
        val duration = intent.getStringExtra("duration")

        val summaryDetailsTV = findViewById<TextView>(R.id.summaryDetailsTV)
        summaryDetailsTV.text = "Booked Cruise:" + bookedCruise +"\n" +
                "totalGuests:"+totalGuests+ "\n"+
                "duration:"+duration+ "\n"+
                "Grand Total: $"+ totalPrice

        // Locate Continue Button
        val continueBtn = findViewById<Button>(R.id.paymentSummaryContinueBtn)
        // Add clickListener to button
        continueBtn.setOnClickListener {

            // Initialize intent object to pass data
            val myIntentObject = Intent(this@Summary, payment::class.java)

            myIntentObject.putExtra("bookedCruise", bookedCruise)
            myIntentObject.putExtra("totalGuests", totalGuests)
            myIntentObject.putExtra("totalPrice", totalPrice)
            myIntentObject.putExtra("duration", duration)

            // Send intent object to TravellersCounter Activity
            startActivity(myIntentObject)
        }
    }
}