package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment2.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {

    lateinit var uname: EditText
    lateinit var fname: EditText
    lateinit var lname: EditText
    lateinit var cname: EditText
    lateinit var aname: EditText
    lateinit var pname: EditText
    lateinit var tname: EditText




    //ViewBinding
    private lateinit var binding: ActivityRegisterBinding

    //ActionBar
    private lateinit var actionBar: ActionBar

    //ProgressDialog
    private lateinit var progressDialog: ProgressDialog

    //FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var database: DatabaseReference

    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Configure Actionbar
        //Enable Back to Button
        actionBar = supportActionBar!!
        actionBar.title = "Sign Up"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        //configure progress dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setMessage("Creating Account In...")
        progressDialog.setCanceledOnTouchOutside(false)

        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()

        uname = findViewById(R.id.inputUsername)
        fname = findViewById(R.id.inputFirstName)
        lname = findViewById(R.id.inputLastName)
        aname = findViewById(R.id.inputAddress)
        pname = findViewById(R.id.inputPostalCode)
        cname = findViewById(R.id.inputCity)
        tname = findViewById(R.id.inputTelephone)


        //handle click, begin signup
        binding.buttonRegister.setOnClickListener {
            //validate data
            validateData()
            saveUserData()

            val username: String = binding.inputUsername.text.toString()

            if(username.isEmpty()) {
                readData(username)
            }

            else {
                Toast.makeText(this, "Please enter username", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun readData(username: String)  {
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(username).get().addOnSuccessListener {
            if(it.exists()){
                val userName = it.child("username").value
                val firstName = it.child("firstname").value
                val lastName = it.child("lastname").value
                Toast.makeText(this, "Successfully Read", Toast.LENGTH_SHORT).show()
            }

            else {
                Toast.makeText(this, "User doesn't exist", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveUserData() {
        val username = uname.text.toString().trim()
        val firstname = fname.text.toString().trim()
        val lastname = lname.text.toString().trim()
        val city = cname.text.toString().trim()
        val address = aname.text.toString().trim()
        val postalcode = pname.text.toString().trim()
        val telephone = tname.text.toString().trim()




        if(username.isEmpty()) {
            uname.error = "Please enter your username."
            return
        }

        if(firstname.isEmpty()) {
            fname.error = "Please enter your firstname."
            return
        }

        if(lastname.isEmpty()) {
            lname.error = "Please enter your lastname."
            return
        }



        if(city.isEmpty()) {
            cname.error = "Please enter your city."
            return
        }

        if(address.isEmpty()) {
            aname.error = "Please enter your address."
            return
        }
        if(postalcode.isEmpty()) {
            pname.error = "Please enter your postal code."
            return
        }

        if(telephone.isEmpty()) {
            tname.error = "Please enter your contact."
            return
        }






        val ref = FirebaseDatabase.getInstance().getReference("data")

        val dataId = ref.push().key

        val data = Data(dataId, username, firstname, lastname, city, address, postalcode, telephone  )

        ref.child(dataId.toString()).setValue(data).addOnCompleteListener {
            Toast.makeText(applicationContext, "data saved successfully", Toast.LENGTH_LONG).show()
        }

    }

    private fun validateData() {
        //get data
        email = binding.emailEt.text.toString().trim()
        password = binding.passwordEt.text.toString().trim()

        //validate data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            //invalid email format
            binding.emailEt.error = "Invalid Email Format"
        }
        else if (TextUtils.isEmpty(password)) {
            //password isn't entered
            binding.passwordEt.error = "Please enter password"
        }

        else if (password.length < 6) {
            //password length is less than 6
            binding.passwordEt.error = "Password must be atleast 6 characters long"
        }

        else {
            //data is valid, continue signup
            firebaseSignUp()
        }
    }

    private fun firebaseSignUp() {
        //show progress
        progressDialog.show()

        //create account
        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                //signup success
                progressDialog.dismiss()

                //get current user
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this, "Account created with email $email", Toast.LENGTH_SHORT).show()


                //open profile
                startActivity(Intent(this, Profile::class.java))
                finish()
            }

            .addOnFailureListener { e->
                //signup failed
                progressDialog.dismiss()
                Toast.makeText(this, "Signup Failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() //go back to previous activity, when back button of actionbar clicked
        return super.onSupportNavigateUp()
    }
}