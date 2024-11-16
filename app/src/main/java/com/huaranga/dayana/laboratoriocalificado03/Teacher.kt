package com.huaranga.dayana.laboratoriocalificado03

import com.google.gson.annotations.SerializedName

data class Teacher(
    val name: String,

    @SerializedName("last_name") // Mapear el campo del JSON
    val lastName: String, // Puedes renombrar la propiedad a "lastName"

    val phone: String,
    val email: String,

    @SerializedName("imageUrl") // Mapear el campo del JSON
    val imageUrl: String
)



