package com.network.layer.models.login

data class Token(
    val access_token: String,
    val expires_in: Int,
    val token_type: String
)