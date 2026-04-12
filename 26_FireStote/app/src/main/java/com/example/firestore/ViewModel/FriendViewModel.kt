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
}