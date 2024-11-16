package com.huaranga.dayana.laboratoriocalificado03

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.huaranga.dayana.laboratoriocalificado03.databinding.ActivityEjercicio01Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Ejercicio01 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Consumir el endpoint
        RetrofitClient.apiService.getTeachers().enqueue(object : Callback<TeacherResponse> {
            override fun onResponse(call: Call<TeacherResponse>, response: Response<TeacherResponse>) {
                if (response.isSuccessful) {
                    val teachers = response.body()?.teachers
                    if (teachers != null) {
                        binding.recyclerView.adapter = TeacherAdapter(this@Ejercicio01, teachers)
                    }
                } else {
                    Toast.makeText(this@Ejercicio01, "Error: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<TeacherResponse>, t: Throwable) {
                Toast.makeText(this@Ejercicio01, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
