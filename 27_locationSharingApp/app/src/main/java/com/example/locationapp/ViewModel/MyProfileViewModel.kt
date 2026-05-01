package com.example.locationapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.locationapp.Model.AppUser
import com.example.locationapp.Repository.UserRepository

class MyProfileViewModel(private val repo: UserRepository) : ViewModel() {

    private val _userData = MutableLiveData<AppUser?>()
    val userData: LiveData<AppUser?> = _userData

    fun fetchUserProfile(uid: String) {
        repo.getUserById(uid) { user ->
            _userData.postValue(user)
        }
    }

    fun updateProfileName(uid: String, newName: String, onResult: (Boolean) -> Unit) {
        repo.updateUserName(uid, newName) { success ->
            onResult(success)
        }
    }
}