package com.example.locationapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.locationapp.Model.AppUser
import com.example.locationapp.Repository.UserRepository

class FriendViewModel(private val repo: UserRepository) : ViewModel() {
    private val _userList = MutableLiveData<List<AppUser>>()
    val userList: MutableLiveData<List<AppUser>> = _userList

    fun fetchUser(){
        repo.getAllUser {
            _userList.postValue(it)
        }
    }
    fun updateProfileName(uid: String, newName: String, onResult: (Boolean) -> Unit) {
        repo.updateUserName(uid, newName) {
            onResult(it)
        }


    }

    val userLocation = MutableLiveData<Pair<Double, Double>>()

    fun logout() {
        repo.logOut()

    }

    fun fetchUserLocation(uid: String) {
        repo.getUserLocation(uid) { lat, lng ->
            if (lat != null && lng != null) {
                userLocation.postValue(Pair(lat, lng))
            }

        }

    }

}