package com.example.firestore.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firestore.Model.AppUser
import com.example.firestore.Model.UserRepository

class FriendViewModel(private val repo: UserRepository) :
    ViewModel() {

    private val _userList = MutableLiveData<List<AppUser>>()
    val userList: MutableLiveData<List<AppUser>> = _userList

    fun fetchUsers() {
        repo.getAllUser { list ->
            _userList.postValue(list)
        }
    }
    fun logOut() {
        repo.logOut()
    }
    fun updateProfileName(uid: String, newName: String, onResult: (Boolean) -> Unit) {
        repo.updateUserName(uid, newName) { success ->
            onResult(success)
        }
    }



    val userLocation = MutableLiveData<Pair<Double, Double>>()

    fun fetchUserLocation(uid: String) {
        repo.getUserLocation(uid) { lat, lng ->
            if (lat != null && lng != null) {
                userLocation.value = Pair(lat, lng)
            }
        }
    }
}