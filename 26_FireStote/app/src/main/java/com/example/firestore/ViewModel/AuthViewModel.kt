package com.example.firestore.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firestore.Model.UserRepository

class AuthViewModel(private val repo: UserRepository) : ViewModel() {

    val loginResult = MutableLiveData<Pair<Boolean, String?>>()
    val registrationResult = MutableLiveData<Pair<Boolean, String?>>()

    val isLoading = MutableLiveData<Boolean>() // progressbar


    fun login(email: String, password: String) {
        isLoading.value = true
        repo.loginUser(email, password) { success, message ->
            isLoading.postValue(false)
            loginResult.postValue(success to message)
        }

    }

    fun register(email: String, password: String) {
        isLoading.value = true
        repo.registerUser(email, password) { success, message ->
            isLoading.value = false
            registrationResult.postValue(success to message)
        }
    }
}