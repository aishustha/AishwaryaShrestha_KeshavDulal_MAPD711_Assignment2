/**
 * Student Id       : 301209947, 301138662
 * Student Name     : Keshav Dulal, Aishwarya Shrestha
 * Course           : MAPD 711 - Samsung Android App Development
 * Submission Date  : 10/18/2021
 * Exercise Number  : A2 - Cruise Booking App
 */

package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.PatternMatcher
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    //state of music player variable

    //ViewBinding
    private lateinit var binding:ActivityMainBinding

    //ActionBar
    private lateinit var actionBar: ActionBar

    //ProgressDialog
    private lateinit var progressDialog: ProgressDialog

    //FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth
    private var email = ""
    private var password = ""

    var isOn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configure actionbar
        actionBar = supportActionBar!!
        actionBar.title = "Login"

        //configure progress dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Logging In...")
        progressDialog.setCanceledOnTouchOutside(false)


        //init firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()


        //handle click, open register activity
        binding.registerBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, Register::class.java)

            //sending data to second activity
            startActivity(intent)
        }

        //handle click, begin login
        binding.signinBtn.setOnClickListener{
        //            val intent = Intent(this@MainActivity, BookingActivity::class.java)
        //
        //            //sending data to second activity
        //            startActivity(intent)


        // before logging in, validate data
            validateData()
        }

        //        val signinBtn= findViewById<Button>(R.id.signinBtn)
        //        val registerBtn = findViewById<Button>(R.id.registerBtn)

        //starts service to play background music
        Intent(this,BackgroundMusicService::class.java).also {
            startService(it)
        }

    }
    // function for toggleing sound on/off
    fun toggleMusic(view: View)
    {
        if (isOn == true){
            //if isOn is true then turn off else turn music on
            Intent(this, BackgroundMusicService::class.java).also {
                stopService(it)
            }
            isOn = false
        } else
        {
            //if isOn is false then turn on e
            Intent(this, BackgroundMusicService::class.java).also {
                startService(it)
            }
            isOn = true
        }

    }

    private fun validateData() {
        //get data
        email = binding.emailEt.text.toString().trim()
        password = binding.passwordEt.text.toString().trim()

        //validate data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            //invalid email format
            binding.emailEt.error = "Invalid email format"
        }

        else if (TextUtils.isEmpty(password)) {
            //no password entered
            binding.passwordEt.error = "Please enter password"
        }

        else {
            //data is validated, begin login
            firebaseLogin()
        }
    }

    private fun firebaseLogin() {
        //show progress
        progressDialog.show()
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                //login success
                progressDialog.dismiss()
                //get user info
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this, "Logged In as $email", Toast.LENGTH_SHORT)
                    .show()

                startActivity(Intent(this, Profile::class.java))
                finish()
            }
            .addOnFailureListener { e->
                //login failed
                progressDialog.dismiss()
                Toast.makeText(this, "Login Failed Due to ${e.message}", Toast.LENGTH_SHORT)
                    .show()
            }
    }

    private fun checkUser() {
        //if user is already logged in go to profile activity
        //get current user
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser != null) {
            //user is already logged in
            startActivity(Intent(this, Profile::class.java))
            finish()
        }
    }
}
