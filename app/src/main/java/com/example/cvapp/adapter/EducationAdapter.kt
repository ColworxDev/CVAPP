package com.example.cvapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cvapp.databinding.ItemEducationBinding

class EducationAdapter(
    private val educations: MutableList<String>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<EducationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemEducationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding).apply {
            itemView.setOnClickListener {
                education?.let(onItemClick::invoke)
            }
        }
    }

    override fun getItemCount(): Int = educations.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.education = educations[position]
        holder.binding.tvEdu.text = educations[position]
    }

    fun remove(education: String) {
        val educationIndex = educations.indexOf(education)
        if (educationIndex != -1) {
            educations.removeAt(educationIndex)
            notifyItemRemoved(educationIndex)
        }
    }

    fun add(education: String) {
        educations.add(education)
        notifyItemChanged(educations.size - 1)
    }

    class ViewHolder(val binding: ItemEducationBinding) : RecyclerView.ViewHolder(binding.root) {
        var education: String? = null
    }
}