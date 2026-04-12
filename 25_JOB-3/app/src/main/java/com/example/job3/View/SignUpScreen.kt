package com.example.job3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.job3.databinding.ActivitySignInScreenBinding
import com.example.job3.databinding.ActivitySignUpScreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.rpc.context.AttributeContext

class SignUpScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpScreenBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        auth = FirebaseAuth.getInstance()
        binding = ActivitySignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.tvSignInLink.setOnClickListener {
            startActivity(Intent(this, SignInScreen::class.java))
            Toast.makeText(this, "Navigate Sign In page", Toast.LENGTH_SHORT).show()

        }
        binding.ivBack.setOnClickListener {
            startActivity(Intent(this, SignInScreen::class.java))
            Toast.makeText(this, "Navigate Sign In page", Toast.LENGTH_SHORT).show()

        }
        binding.btnSignUp.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val email = binding.etEmailPhone.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    this@SignUpScreen,
                    "Please fill up all field",
                    Toast.LENGTH_SHORT
                )
                    .show()
                return@setOnClickListener
            }

            if (!email.endsWith("@dipti.com.bd")) {
                Toast.makeText(this, "Email must be @dipti.com.bd", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, AttributeContext.Auth::class.java))
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