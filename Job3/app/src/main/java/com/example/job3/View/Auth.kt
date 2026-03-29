package com.example.job3.View

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.job3.R
import com.example.job3.databinding.ActivityAuthBinding
import com.example.job3.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class Auth : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()


        binding.tvSignUpLink.setOnClickListener {
            startActivity(Intent(this, SignUpScreen::class.java))
            Toast.makeText(this, "Navigate Sign Up page", Toast.LENGTH_SHORT).show()


        }
        binding.btnLogin.setOnClickListener {
            val email = binding.etemail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {

                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            startActivity(Intent(this, FriendList::class.java))
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
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }

        }

    }
}