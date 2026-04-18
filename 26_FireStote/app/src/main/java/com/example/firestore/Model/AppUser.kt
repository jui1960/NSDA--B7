package com.example.firestore.Model

data class AppUser(
    val userid: String = "",
    val email: String = "",
    val userName : String = "",
    val latitude: Double? = null,
    val longitude: Double? = null,


)
{
    constructor() : this("", "", "", null, null)
}