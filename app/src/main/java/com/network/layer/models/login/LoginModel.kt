package com.network.layer.models.login

data class LoginModel(
    val message: String,
    val token: Token,
    val user: User
)