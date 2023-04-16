package com.example.cvapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.cvapp.R
import com.example.cvapp.databinding.FragmentSkillsBinding
import com.example.cvapp.other.DialogHelper


class SkillsFragment : Fragment() {

    private lateinit var binding: FragmentSkillsBinding
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_skills, container, false)
        binding = FragmentSkillsBinding.bind(view)

        val homeListArray = resources.getStringArray(R.array.skills_items).toList()
        adapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_1, homeListArray)
        adapter.setNotifyOnChange(true)
        binding.listSkills.adapter = adapter

        binding.listSkills.setOnItemClickListener { parent, view, position, id ->
            var item = adapter.getItem(position)!!

            DialogHelper(
                binding.root.context,
                "Confirm",
                "Are you sure you want to delete this item? \n$item"
            ).createDialogConfirm {
                if (it) {
                    adapter.remove(item)
                }
            }
        }
        return view
    }

    fun onClickFAB() {
        DialogHelper(binding.root.context, "Add", "Add new Skills Item").createDialog("") {
            adapter.add(it)
        }
    }

}