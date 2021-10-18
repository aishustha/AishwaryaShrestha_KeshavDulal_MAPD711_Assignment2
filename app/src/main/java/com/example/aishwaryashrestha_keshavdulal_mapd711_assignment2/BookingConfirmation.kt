package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

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
        val postalCode = intent.getStringExtra("postalCode")
        val telephone = intent.getStringExtra("telephone")
        val email = intent.getStringExtra("email")

        // Display the results in a single textview
        val confirmationDetailsTV = findViewById<TextView>(R.id.confirmationDetailsTV)

        //print the values in a text view
        confirmationDetailsTV.text =
            "Customer Name: "+fullName + "\n" +
            "Customer Address: " +address+ "\n" +
            "City and Country: "+ city + country  + "\n"
//            "Visiting Places: " + cruiseDestinations+  "\n" +
//            "Number of Guests: " +totalGuests+  "\n" +
//            "Number of Nights: " +totalNights+  "\n"
//            "Price: " +totalprice+  "\n"

//        # Info to display #
//        Customer Name:
//        Customer Address:
//        City and  Country:
//        Type of Cruise:
//        Visiting Places:
//        Cruise Duration:
//        Number of Guests:
//        Number of Nights:
//        Price:

    }
}