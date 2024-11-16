package com.huaranga.dayana.laboratoriocalificado03

import com.google.gson.annotations.SerializedName

data class Teacher(
    val name: String,

    @SerializedName("last_name")
    val lastName: String,

    val phone: String,
    val email: String,

    @SerializedName("imageUrl")
    val imageUrl: String
)



