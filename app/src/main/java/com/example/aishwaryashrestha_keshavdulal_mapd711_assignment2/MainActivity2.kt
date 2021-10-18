package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain2Binding

    var isBahamasBooked:Boolean=false
    var isCaribbeanBooked:Boolean=false
    var isCubaBooked:Boolean=false
    var isSamplerBooked:Boolean=false
    var isStarBooked:Boolean=false

    public fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

                when (view.id) {
                R.id.bahamasCheckBox -> {
                    if (checked) {
                        isBahamasBooked=true
                    }
                }
                R.id.caribbeanCheckBox -> {
                    if (checked) {
                        isCaribbeanBooked=true
                    }
                }
                R.id.cubaCheckBox -> {
                    if (checked) {
                        isCubaBooked=true
                    }
                }
                R.id.samplerCheckBox -> {
                    if (checked) {
                        isSamplerBooked=true
                    }
                } R.id.starCheckBox -> {
                    if (checked) {
                        isStarBooked=true
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

//        binding.appBarMain.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Cruise Added to Cart", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }

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
            val cruiseBookingsIntentObject = Intent(this@MainActivity2, TravellersCounter::class.java)

            cruiseBookingsIntentObject.putExtra("isBahamasBooked", isBahamasBooked)
            cruiseBookingsIntentObject.putExtra("isCaribbeanBooked", isCaribbeanBooked)
            cruiseBookingsIntentObject.putExtra("isCubaBooked", isCubaBooked)
            cruiseBookingsIntentObject.putExtra("isSamplerBooked", isSamplerBooked)
            cruiseBookingsIntentObject.putExtra("isStarBooked", isStarBooked)


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