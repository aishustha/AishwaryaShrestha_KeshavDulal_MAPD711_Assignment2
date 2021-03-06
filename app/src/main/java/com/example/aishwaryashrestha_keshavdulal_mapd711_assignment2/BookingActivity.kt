/**
 * Student Id       : 301209947, 301138662
 * Student Name     : Keshav Dulal, Aishwarya Shrestha
 * Course           : MAPD 711 - Samsung Android App Development
 * Submission Date  : 10/18/2021
 * Exercise Number  : A2 - Cruise Booking App
 */

package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.CheckBox
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

            // Send intent object to TravellersCounter Activity
            startActivity(cruiseBookingsIntentObject)
        }
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
