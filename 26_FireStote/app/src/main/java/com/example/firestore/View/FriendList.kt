package com.example.firestore.View

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firestore.Adapter.FriendAdapter
import com.example.firestore.Model.UserRepository
import com.example.firestore.ViewModel.FriendViewModel
import com.example.firestore.databinding.ActivityFriendListBinding

class FriendList : AppCompatActivity() {
    private lateinit var binding: ActivityFriendListBinding
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
        binding = ActivityFriendListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = FriendAdapter { selectedUser ->
            Toast.makeText(this@FriendList, selectedUser.email, Toast.LENGTH_SHORT).show()

        }
        binding.userRecycler.layoutManager = LinearLayoutManager(this)
        binding.userRecycler.setHasFixedSize(true)
        binding.userRecycler.adapter = adapter

        viewModel.fetchUsers()

        viewModel.userList.observe(this) { list ->
            val currentUserId = repo.getCurrentUserId()
            val filteredout = list.filter { it.userid != currentUserId }
            adapter.submitList(filteredout)

        }
        loadCurrentUser()
        checkLocationPermission()
    }


    fun loadCurrentUser() {
        val uid = repo.getCurrentUserId() ?: return
        repo.getUserById(uid) { user ->
            user?.let {
                binding.tvMyProfileName.text = it.userName
                binding.tvMyProfileEmail.text = it.email
                binding.tvMyProfileLat.text = it.latitude?.toString() ?: "No Latitude"
                binding.tvMyProfileLng.text = it.longitude?.toString() ?: "No longitude"
            } ?: run {
                binding.tvMyProfileName.text = "User not found"
            }
        }


    }


    private fun hasLocationPermission(): Boolean {
        return ActivityCompat.checkSelfPermission(
            this, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    }

    private fun checkLocationPermission() {
        if (!hasLocationPermission()) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                100
            )
        } else {
            UpdateLocationAutomatically()
        }
    }

    private fun UpdateLocationAutomatically() {
        repo.updateLocationAuto(this) { success ->
            if (success) {
                loadCurrentUser()
            } else {
                Toast.makeText(this, "Location update failed",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }


}