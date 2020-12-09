package com.network.layer.models.cars

data class Model(
    val id: String,
    val image: String,
    val make: Make,
    val name: String,
    val slug: String,
    val typesCount: Int
)