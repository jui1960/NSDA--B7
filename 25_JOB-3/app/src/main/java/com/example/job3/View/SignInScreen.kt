package com.example.job3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.job3.databinding.ActivityMainBinding
import com.example.job3.databinding.ActivitySignInScreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.rpc.context.AttributeContext
import kotlin.toString

class SignInScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySignInScreenBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignInScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
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
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        } else {
                            val exception = task.exception

                            when (exception) {
                                is com.google.firebase.auth.FirebaseAuthInvalidUserException -> {
                                    Toast.makeText(this, "Don't have an account. Please sign up.", Toast.LENGTH_SHORT).show()
                                }
                                is com.google.firebase.auth.FirebaseAuthInvalidCredentialsException -> {
                                    Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show()
                                }
                                else -> {
                                    Toast.makeText(this, "Error: ${exception?.message}", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
