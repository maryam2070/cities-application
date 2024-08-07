package com.example.citiesapplication.domain.models

import com.google.gson.annotations.SerializedName


data class City(
    @SerializedName("_id")
    val id: Int,
    @SerializedName("coord")
    val coordination: Coordination,
    val country: String,
    val name: String
)