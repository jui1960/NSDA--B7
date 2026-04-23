package com.example.locationapp.View

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.locationapp.Repository.UserRepository
import com.example.locationapp.ViewModel.FriendViewModel
import com.example.locationapp.databinding.ActivityMyProfileBinding

class MyProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyProfileBinding
    private val repo = UserRepository()

    private val viewModel by viewModels<FriendViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return FriendViewModel(repo) as T
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMyProfileBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val uid = intent.getStringExtra("uid")
        val email = intent.getStringExtra("email")

        binding.email.text = email


        uid?.let { id ->
            repo.getUserById(id) { user ->
                binding.edtUsername.setText(user?.username)
            }
        }


        binding.btnUpdateUsername.setOnClickListener {
            val newName = binding.edtUsername.text.trim()
            if (newName.isNotEmpty()) {
                uid?.let { id ->
                    viewModel.updateProfileName(id, newName.toString()) { success ->
                        if (success) {
                            finish()
                        } else {
                            Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show()
                        }

                    }
                }
            } else {
                binding.edtUsername.error = "Name cannot be empty"
            }
        }
    }
}