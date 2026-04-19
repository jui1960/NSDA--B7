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
}