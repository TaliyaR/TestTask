package com.example.testtask.entities

import com.google.gson.annotations.SerializedName

data class Candidate(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("detail")
    val detail: String,
    @SerializedName("image_url")
    val image: String
)