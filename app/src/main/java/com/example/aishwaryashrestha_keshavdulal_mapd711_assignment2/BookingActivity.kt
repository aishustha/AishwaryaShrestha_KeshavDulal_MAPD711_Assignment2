/**
 * Student Id       : 301209947, 301138662
 * Student Name     : Keshav Dulal, Aishwarya Shrestha
 * Course           : MAPD 711 - Samsung Android App Development
 * Submission Date  : 10/18/2021
 * Exercise Number  : A2 - Cruise Booking App
 */

package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.databinding.ActivityMain2Binding
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL


class BookingActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain2Binding

    var bookedCruise = ""
    var cruisePrice = 0
    var duration = 0

    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.bahamasCheckBox -> {
                    if (checked) {
                        bookedCruise = "Bahamas"
                        cruisePrice = 1900
                        duration = 3
                    }
                }
                R.id.caribbeanCheckBox -> {
                    if (checked) {
                        bookedCruise = "Caribbean"
                        cruisePrice = 2100
                        duration = 4
                    }
                }
                R.id.cubaCheckBox -> {
                    if (checked) {
                        bookedCruise = "Cuba"
                        cruisePrice = 2200
                        duration = 5
                    }
                }
                R.id.samplerCheckBox -> {
                    if (checked) {
                        bookedCruise = "Sampler"
                        cruisePrice = 2300
                        duration = 6
                    }
                }
                R.id.starCheckBox -> {
                    if (checked) {
                        bookedCruise = "Star"
                        cruisePrice = 2400
                        duration = 7
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.bahamas, R.id.caribbean, R.id.cuba, R.id.sampler, R.id.star
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Locate Continue Button
        val browseContinueBtn = findViewById<Button>(R.id.browseContinueBtn)

        // Add clickListener to button
        browseContinueBtn.setOnClickListener {
            val cruiseBookingsIntentObject =
                Intent(this@BookingActivity, TravellersCounter::class.java)

            cruiseBookingsIntentObject.putExtra("bookedCruise", bookedCruise)
            cruiseBookingsIntentObject.putExtra("cruisePrice", cruisePrice.toString())
            cruiseBookingsIntentObject.putExtra("duration", duration.toString())
//        println("🐞 ${bookedCruise}, ${cruisePrice}, ${duration}")


            // Send intent object to TravellersCounter Activity
            startActivity(cruiseBookingsIntentObject)
        }

        // BUGGY CODE BLOCK - BEGIN
        val textViewStatus = findViewById<TextView>(R.id.imageFetchStatus)
        textViewStatus.text="Image Fetch Status: Unknown"
        // fetch cruise images from url using coroutines and store it on imageView
        GlobalScope.launch(Dispatchers.IO) {
            // N/w activity is ran on Background Thread

            // bahamas
            val imageUrl =
                        "https://images.unsplash.com/photo-1554254648-2d58a1bc3fd5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2342&q=80"
            val url = URL(imageUrl)
            val connection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()

            val inputStream = connection.inputStream
            val bitmap = BitmapFactory.decodeStream(inputStream)

            // caribbean
//            val imageUrl2 =
//                "https://images.unsplash.com/photo-1554254648-2d58a1bc3fd5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2342&q=80"
//            val url2 = URL(imageUrl2)
//            val connection2 = url2.openConnection() as HttpURLConnection
//            connection2.doInput = true
//            connection2.connect()
//            val inputStream2 = connection2.inputStream
//            val bitmap2 = BitmapFactory.decodeStream(inputStream2)
//
//            //cuba
//            val imageUrl3 =
//                "https://images.unsplash.com/photo-1554254648-2d58a1bc3fd5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2342&q=80"
//            val url3 = URL(imageUrl3)
//            val connection3 = url3.openConnection() as HttpURLConnection
//            connection3.doInput = true
//            connection3.connect()
//            val inputStream3 = connection3.inputStream
//            val bitmap3 = BitmapFactory.decodeStream(inputStream3)
//
//            //sampler
//            val imageUrl4 =
//                "https://images.unsplash.com/photo-1554254648-2d58a1bc3fd5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2342&q=80"
//            val url4 = URL(imageUrl4)
//            val connection4 = url4.openConnection() as HttpURLConnection
//            connection4.doInput = true
//            connection4.connect()
//            val inputStream4 = connection4.inputStream
//            val bitmap4 = BitmapFactory.decodeStream(inputStream4)
//
//            //star
//            val imageUrl5 =
//                "https://images.unsplash.com/photo-1554254648-2d58a1bc3fd5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2342&q=80"
//            val url5 = URL(imageUrl4)
//            val connection5 = url5.openConnection() as HttpURLConnection
//            connection5.doInput = true
//            connection5.connect()
//            val inputStream5 = connection4.inputStream
//            val bitmap5 = BitmapFactory.decodeStream(inputStream5)

            // Switching scope to Main Thread to access the View
            launch(Dispatchers.Main) {
                textViewStatus.text="Image Fetch Status: Success"
                val imageView4 = findViewById<ImageView>(R.id.imageView4) // bahamas
                imageView4.setImageBitmap(bitmap)

//                val imageView3 = findViewById<ImageView>(R.id.imageView3) //caribbean
//                imageView3.setImageBitmap(bitmap2)
//
//                val imageView6 = findViewById<ImageView>(R.id.imageView6) //cuba
//                imageView6.setImageBitmap(bitmap3)
//
//                val imageView5 = findViewById<ImageView>(R.id.imageView5) //sampler
//                imageView5.setImageBitmap(bitmap4)
//
//                val imageView7 = findViewById<ImageView>(R.id.imageView7) //star
//                imageView7.setImageBitmap(bitmap5)

            }
        }
        // END of buggy code block

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_activity2, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
