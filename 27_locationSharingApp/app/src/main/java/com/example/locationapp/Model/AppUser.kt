package com.example.locationapp.Model

data class AppUser(
    val userid : String = "",
    val email: String = "",
    val username : String = "",
    val latitude : Double ?= null,
    val longitude : Double ?= null
){
    constructor():this("","","",null,null)
}
