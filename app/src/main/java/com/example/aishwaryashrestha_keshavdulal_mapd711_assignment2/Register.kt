package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var str_username : String
        lateinit var str_password: String
        lateinit var str_fname: String
        lateinit var str_lname: String
        lateinit var str_address: String
        lateinit var str_city: String
        lateinit var str_postcode: String
        lateinit var str_telephone: String
        lateinit var str_email: String
        
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var register = findViewById<Button>(R.id.buttonRegister)
        register.setOnClickListener {

            // Getting details from user
            str_username = findViewById<EditText>(R.id.inputUsername).toString()
            str_postcode = findViewById<EditText>(R.id.inputPassword).toString()
            str_fname = findViewById<EditText>(R.id.inputFirstName).toString()
            str_lname = findViewById<EditText>(R.id.inputLastName).toString()
            str_address = findViewById<EditText>(R.id.inputAddress).toString()
            str_city = findViewById<EditText>(R.id.inputCity).toString()
            str_postcode = findViewById<EditText>(R.id.inputPostalCode).toString()
            str_telephone = findViewById<EditText>(R.id.inputTelephone).toString()
            str_email = findViewById<EditText>(R.id.inputEmail).toString()

            val url = "https://centencruiseinc-default-rtdb.firebaseio.com"

            // Linking data with Firebase database
            val ref = FirebaseDatabase.getInstance().getReference(url)

            val detailsId = ref.push().key.toString()

            val record = UserDetails(detailsId,str_username,str_password,str_fname,str_lname,str_address,str_city,str_postcode,str_telephone,str_email)
            ref.child(detailsId).setValue(record).addOnCompleteListener{
                Toast.makeText(applicationContext,"Details saved",Toast.LENGTH_LONG).show()
            }
        }
    }
}