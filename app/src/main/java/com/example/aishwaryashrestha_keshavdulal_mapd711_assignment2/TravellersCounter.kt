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
//    ,AdapterView.OnItemSelectedListener

//    var kidCount=0
//    var adultCount=0
//    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
//        // Retrieve the selected item using
//        adultCount = parent.getItemAtPosition(pos) as Int
//    }
//    override fun onNothingSelected(parent: AdapterView<*>) {
//        // Another interface callback
//    }
//    public fun onKidCountSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
//        kidCount = parent.getItemAtPosition(pos) as Int
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travellers_counter)

        // Populate spinners
        // ref: https://developer.android.com/guide/topics/ui/controls/spinner
        val adultCounterSpinner: Spinner = findViewById(R.id.adultCounterSpinner)

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(this,R.array.counter,android.R.layout.simple_spinner_item)
            .also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            adultCounterSpinner.adapter = adapter
        }

        val kidCounterSpinner: Spinner = findViewById(R.id.kidCounterSpinner)
        ArrayAdapter.createFromResource(this, R.array.counter, android.R.layout.simple_spinner_item)
            .also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            kidCounterSpinner.adapter = adapter
        }


//        val spinner: Spinner = findViewById(R.id.spinner)
//        adultCounterSpinner.onItemSelectedListener = this
//        kidCounterSpinner.onItemSelectedListener = this

        // Collect data from intent object
        val intent = intent

        // Extract values from intent object using relevant keys
        val isBahamasBooked = intent.getStringExtra("isBahamasBooked")
        //        isCaribbeanBooked
        //        isCubaBooked
        //        isSamplerBooked
        //        isStarBooked




        val seniorRadioYes =findViewById<RadioButton>(R.id.adultYesRadioBtn)
        val isSeniorPresent:Boolean = seniorRadioYes.isChecked

        // Locate Continue Button
        val continueBtn = findViewById<Button>(R.id.travellersCountContinueBtn)

        // Add clickListener to button
        continueBtn.setOnClickListener {
            val adultCount: String = adultCounterSpinner.selectedItem.toString()
            val kidCount: String = adultCounterSpinner.selectedItem.toString()

            // Initialize intent object to pass data
            val myIntentObject = Intent(this@TravellersCounter, Summary::class.java)
            myIntentObject.putExtra("adultCount", adultCount)
            myIntentObject.putExtra("kidCount", kidCount)
            myIntentObject.putExtra("isSeniorPresent", isSeniorPresent)
            myIntentObject.putExtra("isBahamasBooked", isBahamasBooked)

            // Send intent object to TravellersCounter Activity
            startActivity(myIntentObject)
        }
    }
}