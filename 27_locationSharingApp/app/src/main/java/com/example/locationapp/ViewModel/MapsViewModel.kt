package com.example.locationapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.locationapp.Model.AppUser
import com.example.locationapp.Repository.UserRepository

class MapsViewModel(private val repo: UserRepository) : ViewModel() {

    private val _userList = MutableLiveData<List<AppUser>>()
    val userList: LiveData<List<AppUser>> = _userList


    private val _singleUserLocation = MutableLiveData<Pair<Double, Double>?>()
    val singleUserLocation: LiveData<Pair<Double, Double>?> = _singleUserLocation

    fun fetchAllUsers() {
        repo.getAllUser { list ->
            _userList.postValue(list)
        }
    }

    fun fetchUserLocation(uid: String) {
        repo.getUserById(uid) { user ->
            if (user?.latitude != null && user.longitude != null) {
                _singleUserLocation.postValue(Pair(user.latitude!!, user.longitude!!))
            }
        }
    }
}