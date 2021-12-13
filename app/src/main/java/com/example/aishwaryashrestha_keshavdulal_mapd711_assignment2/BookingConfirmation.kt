/**
 * Student Id       : 301209947, 301138662
 * Student Name     : Keshav Dulal, Aishwarya Shrestha
 * Course           : MAPD 711 - Samsung Android App Development
 * Submission Date  : 10/18/2021
 * Exercise Number  : A2 - Cruise Booking App
 */
package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.io.FileOutputStream
import java.io.OutputStreamWriter

@Suppress("DEPRECATION")
class BookingConfirmation : AppCompatActivity() {
    //state of music variable
    var isOn = true

    var userName: String = ""
    var fullName: String = ""
    var address: String = ""
    var city: String = ""
    var country: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_confirmation)

        readData("Aishwarya Shrestha")

        // Collect data from intent object
        val intent = intent


        // Extract values from intent object using relevant keys
//        val fullName = intent.getStringExtra("fullName")
//        val address = intent.getStringExtra("address")
//        val city = intent.getStringExtra("city")
//        val country = intent.getStringExtra("country")
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

        val printbtn = findViewById<Button>(R.id.printbtn)
        printbtn.setOnClickListener {
            try {
                val fileOutputStream: FileOutputStream =
                    openFileOutput("booking_details.txt", Context.MODE_PRIVATE)
                val outputWriter = OutputStreamWriter(fileOutputStream)
                outputWriter.write("\t\tCenten Cruise Inc Booking details\n\n")
                outputWriter.write(confirmationDetailsTV.text.toString())
                outputWriter.write("\n\n")
                outputWriter.write("\t\tThank you for booking your tour with us")
                outputWriter.close()
                //playSound()
                //display file saved message
                Toast.makeText(baseContext, "File saved successfully!", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            //***************************ThankYou service called************************
            //plays background thank you message service
            Intent(this, ThankYouSoundService::class.java).also {
                startService(it)
            }
        }//close btnPressed

    }//close onCreate

    // function for toggleing sound on/off
    fun toggleMusic(view: View) {
        if (isOn === true) {
            //if isOn is true then turn off else turn music on
            Intent(this, BackgroundMusicService::class.java).also {
                stopService(it)
            }
            isOn = false
        } else {
            //if isOn is false then turn on e
            Intent(this, BackgroundMusicService::class.java).also {
                startService(it)
            }
            isOn = true
        }

    }

    private fun readData(username: String) {
        val databaseRef = FirebaseDatabase.getInstance().getReference("data")
//        val databaseRef = FirebaseDatabase.getInstance().getReference("data")
//        databaseRef.child(username.toString()).get().addOnSuccessListener {
//            if(it.exists()){
//                userName = it.child("username").value.toString()
//                val firstName = it.child("firstname").value.toString()
//                val lastName = it.child("lastname").value.toString()
//                fullName= firstName + lastName
//                address = it.child("address").value.toString()
//                city = it.child("city").value.toString()
//                Toast.makeText(this, "Successfully Read", Toast.LENGTH_SHORT).show()
//            }
//
//            else {
//                Toast.makeText(this, "UserInfo Fetch Failed", Toast.LENGTH_SHORT).show()
//            }
//        }

        // ------------------------
        val docRef = databaseRef.collection("data").document("SF")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }

    }

}
