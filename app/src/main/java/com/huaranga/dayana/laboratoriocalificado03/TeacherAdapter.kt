package com.huaranga.dayana.laboratoriocalificado03

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.huaranga.dayana.laboratoriocalificado03.databinding.ItemTeacherBinding

class TeacherAdapter(
    private val context: Context,
    private val teachers: List<Teacher>
) : RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>() {

    // Clase interna para el ViewHolder
    inner class TeacherViewHolder(val binding: ItemTeacherBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        // Infla el layout y crea el ViewHolder
        val binding = ItemTeacherBinding.inflate(LayoutInflater.from(context), parent, false)
        return TeacherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val teacher = teachers[position]

        // Asigna valores a los elementos del layout
        holder.binding.textViewName.text = teacher.name
        holder.binding.textViewSurname.text = teacher.lastName // Usamos lastName del modelo
        Picasso.get().load(teacher.imageUrl).into(holder.binding.imageView)

        // Clic simple: Llamar al número del profesor
        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${teacher.phone}"))
            context.startActivity(intent)
        }

        // Clic largo: Enviar un correo al profesor
        holder.itemView.setOnLongClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${teacher.email}")
            }
            context.startActivity(intent)
            true
        }
    }

    override fun getItemCount(): Int = teachers.size // Tamaño de la lista
}