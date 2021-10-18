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
        val isBahamasBooked = intent.getStringExtra("isBahamasBooked")
        //        isCaribbeanBooked
        //        isCubaBooked
        //        isSamplerBooked
        //        isStarBooked
        val kidCount = intent.getStringExtra("kidCount")
        val adultCount = intent.getStringExtra("adultCount")

        val summaryDetailsTV = findViewById<TextView>(R.id.summaryDetailsTV)
        summaryDetailsTV.text = "isBahamasBooked:" + isBahamasBooked.toString() +"\n" +

                "Kids:"+kidCount+ "\n"+
                "Adults:"+adultCount+ "\n"+
                "Grand Total: $"+ (kidCount?.toInt()?.times(500) ?: 0) + (adultCount?.toInt()?.times(1000)
            ?:0 )

        // Locate Continue Button
        val continueBtn = findViewById<Button>(R.id.paymentSummaryContinueBtn)
        // Add clickListener to button
        continueBtn.setOnClickListener {

            // Initialize intent object to pass data
            val myIntentObject = Intent(this@Summary, payment::class.java)
//            myIntentObject.putExtra("adultCount", adultCount)
//            myIntentObject.putExtra("kidCount", kidCount)
//            myIntentObject.putExtra("isSeniorPresent", isSeniorPresent)

            // Send intent object to TravellersCounter Activity
            startActivity(myIntentObject)
        }
    }
}