package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
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

        // Extract info and pass it to Summary Activity
        // Add clickListener to button
        browseContinueBtn.setOnClickListener {

            // Initialize intent object to pass data
            val cruiseBookingsIntentObject = Intent(this@MainActivity2, TravellersCounter::class.java)

            // Store bookings in the newly created intent object
//            cruiseBookingsIntentObject.putExtra("isBahamasBooked", BahamasCheckBox.isChecked)
//            cruiseBookingsIntentObject.putExtra("isCaribbeanBooked", CaribbeanCheckBox.isChecked)
//            cruiseBookingsIntentObject.putExtra("isCubaBooked", CubaCheckBox.isChecked)
//            cruiseBookingsIntentObject.putExtra("isSamplerBooked", SamplerCheckBox.isChecked)
//            cruiseBookingsIntentObject.putExtra("isStarBooked", StarCheckBox.isChecked)

            // Send intent object to TravellersCounter Activity
            startActivity(cruiseBookingsIntentObject)
        }
    }
}