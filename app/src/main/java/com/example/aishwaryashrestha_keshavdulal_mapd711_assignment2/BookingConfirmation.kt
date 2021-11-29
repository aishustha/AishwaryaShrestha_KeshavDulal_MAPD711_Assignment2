/**
 * Student Id       : 301209947, 301138662
 * Student Name     : Keshav Dulal, Aishwarya Shrestha
 * Course           : MAPD 711 - Samsung Android App Development
 * Submission Date  : 10/18/2021
 * Exercise Number  : A2 - Cruise Booking App
 */
package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class BookingConfirmation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_confirmation)

        // Collect data from intent object
        val intent = intent

        // Extract values from intent object using relevant keys
        val fullName = intent.getStringExtra("fullName")
        val address = intent.getStringExtra("address")
        val city = intent.getStringExtra("city")
        val country = intent.getStringExtra("country")
//        val postalCode = intent.getStringExtra("postalCode")
//        val telephone = intent.getStringExtra("telephone")
//        val email = intent.getStringExtra("email")

        val bookedCruise = intent.getStringExtra("bookedCruise")
        val totalGuests = intent.getStringExtra("totalGuests")
        val totalPrice = intent.getStringExtra("totalPrice")
        val duration = intent.getStringExtra("duration")

        // Display the results in a single textview
        val confirmationDetailsTV = findViewById<TextView>(R.id.confirmationDetailsTV)

        //print the values in a text view
        confirmationDetailsTV.text =
            "Customer Name: " + fullName + "\n" +
                    "Customer Address: " + address + "\n" +
                    "City and Country: " + city + country + "\n" +
                    "Visiting Places: " + bookedCruise + "\n" +
                    "Number of Guests: " + totalGuests + "\n" +
                    "Number of Nights: " + duration + "\n" +
                    "Price: " + totalPrice
    }
    // Function for button send
    fun print_text(view: android.view.View) {

        if (view.id == R.id.printbtn) {

            var textview = findViewById<TextView>(R.id.confirmationDetailsTV)

            try {
                val fileOutputStream: FileOutputStream = openFileOutput("booking_details.txt", Context.MODE_PRIVATE)
                val outputWriter = OutputStreamWriter(fileOutputStream)
                outputWriter.write(textview.text.toString())
                outputWriter.close()
                //display file saved message
                Toast.makeText(baseContext, "File saved successfully!", Toast.LENGTH_SHORT).show()
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
        }
}
