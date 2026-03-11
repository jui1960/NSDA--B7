package com.example.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firebaseauth.databinding.ActivityLogInScreenBinding
import com.example.firebaseauth.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class LogInScreen : AppCompatActivity() {
    private lateinit var binding: ActivityLogInScreenBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLogInScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()


        binding.goSignup.setOnClickListener {
            startActivity(Intent(this, SignUpScreen::class.java))
            Toast.makeText(this, "Navigate Sign Up page", Toast.LENGTH_SHORT).show()
        }
        binding.loginBtn.setOnClickListener {

            val email = binding.email.text.toString().trim()
            val password = binding.password.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            startActivity(Intent(this, HomeScreen::class.java))
                            finish()
                        } else {
                            val exception = task.exception
                            if (exception is com.google.firebase.auth.FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show()
                            } else if (exception is com.google.firebase.auth.FirebaseAuthInvalidUserException) {
                                Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(
                                    this,
                                    "Error: ${exception?.message}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                        }

                    }
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }

        }

    }
}