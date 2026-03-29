package com.example.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firebaseauth.databinding.ActivitySignUpScreenBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpScreenBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth = FirebaseAuth.getInstance()

        binding.goLogin.setOnClickListener {
            Toast.makeText(this, "Navigate to LogIn Page", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LogInScreen::class.java))
            finish()
        }
        binding.signupBtn.setOnClickListener {
            val name = binding.name.text.toString().trim()
            val email = binding.signupEmail.text.toString().trim()
            val password = binding.signupPassword.text.toString().trim()
            val confirmPassword = binding.confirmPassword.text.toString().trim()



            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this@SignUpScreen, "Please fill up all feild", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            if (!email.endsWith("@dipti.com.bd")) {
                Toast.makeText(this, "Email must be @dipti.com.bd", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this@SignUpScreen, "Passwords do not match", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            } else {
                "invalid password"
            }

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, LogInScreen::class.java))
                    } else {
                        Toast.makeText(
                            this,
                            "Registration Failed : ${task.exception?.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
        }

    }
}
