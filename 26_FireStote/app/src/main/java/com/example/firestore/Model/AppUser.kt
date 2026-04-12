package com.example.firestore.Model

data class AppUser(
    val userid: String = "",
    val email: String = "",
    val userName : String = "",
    val latitude : Double = 0.0,
    val longitude : Double = 0.0,


)
{
    constructor():this("","","",
        0.0,0.0)
}