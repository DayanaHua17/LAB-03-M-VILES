
package com.huaranga.dayana.laboratoriocalificado03

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/list/teacher") // Cambiar endpoint al nuevo path
    fun getTeachers(): Call<TeacherResponse>
}


