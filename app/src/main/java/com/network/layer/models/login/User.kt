package com.network.layer.models.login

data class User(
    val address: String,
    val avatar: Any,
    val email: String,
    val id: Int,
    val isAdmin: Boolean,
    val name: String,
    val phone: String,
    val settings: List<Any>,
    val stores: List<Store>
)