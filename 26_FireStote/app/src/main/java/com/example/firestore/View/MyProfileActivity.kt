package com.example.firestore.View

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firestore.Model.UserRepository
import com.example.firestore.ViewModel.FriendViewModel
import com.example.firestore.databinding.ActivityMyProfileBinding

class MyProfileActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMyProfileBinding

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

        val uid = intent.getStringExtra("uid")
        val email = intent.getStringExtra("email")

        binding.email.text = email

        uid?.let { id ->
            repo.getUserById(id) { user ->
                binding.edtUsername.setText(user?.userName)
            }
        }

        binding.btnUpdateUsername.setOnClickListener {
            val newName = binding.edtUsername.text.toString().trim()
            if (newName.isNotEmpty() && uid != null) {
                viewModel.updateProfileName(uid, newName) { success ->
                    if (success) {
                        Toast.makeText(this, "Name Updated!", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(this, "Update Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                binding.edtUsername.error = "Name cannot be empty"
            }
        }

        binding.btnMap.setOnClickListener {
            if (uid != null) {
                val intent = Intent(this, MapsActivity::class.java)
                intent.putExtra("uid", uid)
                startActivity(intent)
            } else {
                Toast.makeText(this, "User ID not found", Toast.LENGTH_SHORT).show()
            }
        }
    }
    }





