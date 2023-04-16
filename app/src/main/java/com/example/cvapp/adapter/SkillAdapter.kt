package com.example.cvapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cvapp.databinding.ItemSkillBinding
import com.example.cvapp.model.Skill

class SkillAdapter(
    private val onSkillClick: (Skill) -> Unit
) : ListAdapter<Skill, SkillAdapter.ViewHolder>(SkillDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSkillBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding).apply {
            binding.rbLevel.setOnRatingBarChangeListener { _, rating, _ ->
                skill = skill?.copy(level = rating)
            }
            itemView.setOnClickListener {
                skill?.let(onSkillClick::invoke)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val skill = getItem(position)
        holder.skill = skill
        with(holder.binding) {
            tvSkill.text = skill.content
            rbLevel.rating = skill.level
        }
    }

    fun remove(skill: Skill) {
        currentList.filter { it != skill }
            .let(::submitList)
    }

    fun add(skill: Skill) {
        buildList {
            addAll(currentList)
            add(skill)
        }
            .let(::submitList)
    }

    class ViewHolder(val binding: ItemSkillBinding) : RecyclerView.ViewHolder(binding.root) {
        var skill: Skill? = null
    }

    private class SkillDiffCallBack : DiffUtil.ItemCallback<Skill>() {
        override fun areItemsTheSame(oldItem: Skill, newItem: Skill) = oldItem === newItem
        override fun areContentsTheSame(oldItem: Skill, newItem: Skill) = oldItem == newItem
    }
}