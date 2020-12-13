package com.network.layer.models.login

data class Store(
    val cities: List<City>,
    val email: String,
    val facebook: String,
    val id: Int,
    val instagram: String,
    val is_follow: Boolean,
    val logo: Logo,
    val name: String,
    val phone: String,
    val status: Int,
    val types: List<Type>
)