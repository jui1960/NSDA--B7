package com.example.firestore.View

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
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
    private var isMenuOpen = false
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
            startActivity(Intent(this, MapsActivity::class.java).apply {
                putExtra("uid", selectedUser.userid)
            })

        }
        binding.userRecycler.layoutManager = LinearLayoutManager(this)
        binding.userRecycler.setHasFixedSize(true)
        binding.userRecycler.adapter = adapter

        viewModel.fetchUsers()

        viewModel.userList.observe(this) { list ->
            val currentUid = repo.getCurrentUserId()
            adapter.submitList(list.filter { it.userid != currentUid })

        }
        loadCurrentUser()
        checkLocationPermission()

        binding.layoutMyProfile.setOnClickListener {
            val uid = repo.getCurrentUserId() ?: return@setOnClickListener
            startActivity(Intent(this, MapsActivity::class.java).apply {
                putExtra("uid", uid)
            })
        }
        binding.fabMain.setOnClickListener {
            if (isMenuOpen) closeMenu() else openMenu()
        }

        binding.fabProfile.setOnClickListener {
            val uid = repo.getCurrentUserId() ?: return@setOnClickListener
            val email = repo.getCurrentUserEmail() ?: ""

            startActivity((Intent(this, MyProfileActivity::class.java)).apply {
                putExtra("uid", uid)
                putExtra("email", email)

            })
            closeMenu()
        }
        binding.fabShowMap.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java).apply {
                putExtra("showAll", true)
            })
            closeMenu()
        }

        binding.fabLogout.setOnClickListener {
            viewModel.logOut()

            startActivity(Intent(this, AddScreen::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            })
        }



    }

    @SuppressLint("SetTextI18n")
    fun loadCurrentUser() {
        val uid = repo.getCurrentUserId() ?: return
        repo.getUserById(uid) { user ->
            user?.let {
                binding.tvMyProfileName.text = it.userName
                binding.tvMyProfileEmail.text = it.email
                binding.tvMyProfileLat.text = "Lat: ${it.latitude ?: 0.0}"
                binding.tvMyProfileLng.text = "Lng: ${it.longitude ?: 0.0}"
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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(
            requestCode,
            permissions, grantResults
        )

        if (requestCode == 100 && grantResults.isNotEmpty()
            && grantResults[0] == PackageManager.PERMISSION_GRANTED
        ) {
            UpdateLocationAutomatically()
        }
    }


    private fun UpdateLocationAutomatically() {
        repo.updateLocationAuto(this) { success ->
            if (success) {
                loadCurrentUser()
            } else {
                Toast.makeText(
                    this, "Location update failed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }





    private fun openMenu() {
        binding.fabProfile.visibility = View.VISIBLE
        binding.fabLogout.visibility = View.VISIBLE
        binding.fabShowMap.visibility = View.VISIBLE
        isMenuOpen = true

    }

    private fun closeMenu() {
        binding.fabProfile.visibility = View.GONE
        binding.fabLogout.visibility = View.GONE
        binding.fabShowMap.visibility = View.GONE
        isMenuOpen = false


    }


    override fun onResume() {
        super.onResume()

        isMenuOpen = false
        closeMenu()
    }


}