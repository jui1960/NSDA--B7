package com.example.firestore.View

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

    // কোন বাটনটি বর্তমানে লোডিং মোডে আছে তা ট্র্যাক করার জন্য
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
        // ১. লোডিং স্টেট অবজার্ভ করা
        viewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                // একটি বাটন লোডিং হলে দুটোই ডিসেবল করে দিচ্ছি যাতে ইউজার ডাবল ক্লিক না করে
                binding.btnLogin.isEnabled = false
                binding.btnRegister.isEnabled = false
            } else {
                // লোডিং শেষ হলে এক্টিভ বাটনটিকে স্টপ করা
                activeLoadingButton?.let {
                    val originalText = if (it == binding.btnLogin) "Login" else "Register"
                    stopLoading(it, originalText)
                }
                binding.btnLogin.isEnabled = true
                binding.btnRegister.isEnabled = true
                activeLoadingButton = null
            }
        }

        // ২. রেজাল্ট অবজার্ভ করা (Login)
        viewModel.loginResult.observe(this) { (success, message) ->
            if (success) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login Failed: $message", Toast.LENGTH_LONG).show()
            }
        }

        // ৩. রেজাল্ট অবজার্ভ করা (Registration)
        viewModel.registrationResult.observe(this) { (success, message) ->
            if (success) {
                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Registration Failed: $message", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setupClickListeners() {
        // লগইন বাটন ক্লিক
        binding.btnLogin.setOnClickListener {
            val email = binding.email.text.toString().trim()
            val password = binding.password.text.toString().trim()

            if (validateInputs(email, password)) {
                activeLoadingButton = binding.btnLogin
                startLoading(binding.btnLogin)
                viewModel.login(email, password)
            }
        }

        // রেজিস্ট্রেশন বাটন ক্লিক
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
        return if (email.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            false
        } else true
    }

    // --- লোডিং হেল্পার ফাংশন ---

    private fun startLoading(button: MaterialButton) {
        val spec = CircularProgressIndicatorSpec(this, null).apply {
            indicatorColors = intArrayOf(Color.WHITE)
            indicatorSize = (button.height * 0.5).toInt()
            trackThickness = 6
        }

        val progressDrawable = IndeterminateDrawable.createCircularDrawable(this, spec)

        button.icon = progressDrawable
        button.text = "" // টেক্সট সরিয়ে ফেলা হলো যাতে শুধু স্পিনার দেখা যায়
        button.isEnabled = false
    }

    private fun stopLoading(button: MaterialButton, originalText: String) {
        button.icon = null
        button.text = originalText
        button.isEnabled = true
    }
}