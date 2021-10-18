package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.Spinner

class TravellersCounter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travellers_counter)

        // Populate spinners
        // ref: https://developer.android.com/guide/topics/ui/controls/spinner
        val adultCounterSpinner: Spinner = findViewById(R.id.adultCounterSpinner)

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.counter,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
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

        // Collect data from intent object
        val intent = intent

        // Extract values from intent object using relevant keys
        val isBahamasBooked = intent.getStringExtra("isBahamasBooked")
        //        isCaribbeanBooked
        //        isCubaBooked
        //        isSamplerBooked
        //        isStarBooked

        val adultSpinner = findViewById<Spinner>(R.id.adultCounterSpinner)
        val adultCount: String = adultSpinner.getSelectedItem().toString()

        val kidSpinner = findViewById<Spinner>(R.id.kidCounterSpinner)
        val kidCount: String = kidSpinner.getSelectedItem().toString()

        val seniorRadioYes =findViewById<RadioButton>(R.id.adultYesRadioBtn)
        val isSeniorPresent:Boolean = seniorRadioYes.isChecked

        // Locate Continue Button
        val continueBtn = findViewById<Button>(R.id.travellersCountContinueBtn)

        // Add clickListener to button
        continueBtn.setOnClickListener {

            // Initialize intent object to pass data
            val myIntentObject = Intent(this@TravellersCounter, Summary::class.java)
            myIntentObject.putExtra("adultCount", adultCount)
            myIntentObject.putExtra("kidCount", kidCount)
            myIntentObject.putExtra("isSeniorPresent", isSeniorPresent)

            // Send intent object to TravellersCounter Activity
            startActivity(myIntentObject)
        }
    }
}