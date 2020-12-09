package com.network.layer.models.cars

data class Data(
    val counts: Counts,
    val id: String,
    val images: List<Any>,
    val `is`: Is,
    val model: Model,
    val name: String,
    val reviews: Reviews,
    val slug: String
)