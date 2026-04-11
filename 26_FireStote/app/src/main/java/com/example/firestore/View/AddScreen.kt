package com.example.firestore.View

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firestore.Model.UserRepository
import com.example.firestore.ViewModel.AuthViewModel
import com.example.firestore.databinding.ActivityAddScreenBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec
import com.google.android.material.progressindicator.IndeterminateDrawable

class AddScreen : AppCompatActivity() {
    private lateinit var binding: ActivityAddScreenBinding

    private val repo = UserRepository()
    private val viewModel: AuthViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return AuthViewModel(repo) as T
            }
        }
    }


    private var activeLoadingButton: MaterialButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
        setupClickListeners()
    }

    private fun setupObservers() {

        viewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {

                binding.btnLogin.isEnabled = false
                binding.btnRegister.isEnabled = false
            } else {

                activeLoadingButton?.let {
                    val originalText = if (it == binding.btnLogin) "Login" else "Register"
                    stopLoading(it, originalText)
                }
                binding.btnLogin.isEnabled = true
                binding.btnRegister.isEnabled = true
                activeLoadingButton = null
            }
        }


        viewModel.loginResult.observe(this) { (success, message) ->
            if (success) {
                Toast.makeText(this, "Login Successful! ", Toast.LENGTH_SHORT).show()
                navigateToFriendList()
            } else {
                Toast.makeText(this, "Login Failed ", Toast.LENGTH_LONG).show()
            }
        }


        viewModel.registrationResult.observe(this) { (success, message) ->
            if (success) {
                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Registration Failed ", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setupClickListeners() {
        binding.btnLogin.setOnClickListener {
            val email = binding.email.text.toString().trim()
            val password = binding.password.text.toString().trim()

            if (validateInputs(email, password)) {
                activeLoadingButton = binding.btnLogin
                startLoading(binding.btnLogin)
                viewModel.login(email, password)
            }
        }

        binding.btnRegister.setOnClickListener {
            val email = binding.email.text.toString().trim()
            val password = binding.password.text.toString().trim()

            if (validateInputs(email, password)) {
                activeLoadingButton = binding.btnRegister
                startLoading(binding.btnRegister)
                viewModel.register(email, password)
            }
        }
    }

    private fun validateInputs(email: String, pass: String): Boolean {
        if (email.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            false
        }
        if (pass.isEmpty()) {
            Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show()
            return false
        }

        if (pass.length < 6) {
            Toast.makeText(this, "Password must be at least 6 characters long", Toast.LENGTH_SHORT)
                .show()
            return false
        }

        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z]).{6,}$".toRegex()
        if (!pass.matches(passwordPattern)) {
            Toast.makeText(
                this,
                "Password must contain at least one letter and one number",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }
        return true
    }


    private fun startLoading(button: MaterialButton) {
        val spec = CircularProgressIndicatorSpec(this, null).apply {
            indicatorColors = intArrayOf(Color.WHITE)
            indicatorSize = (button.height * 0.5).toInt()
            trackThickness = 6
        }

        val progressDrawable = IndeterminateDrawable.createCircularDrawable(this, spec)

        button.icon = progressDrawable
        button.text = ""
        button.isEnabled = false
    }

    private fun stopLoading(button: MaterialButton, originalText: String) {
        button.icon = null
        button.text = originalText
        button.isEnabled = true
    }

    private fun navigateToFriendList() {
        val intent = Intent(this, FriendList::class.java)
        startActivity(intent)
        finish()
    }
}