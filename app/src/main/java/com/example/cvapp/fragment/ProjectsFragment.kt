package com.example.cvapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.cvapp.R
import com.example.cvapp.databinding.FragmentHomeBinding
import com.example.cvapp.databinding.FragmentProjectsBinding
import com.example.cvapp.other.DialogHelper


class ProjectsFragment : Fragment() {

    private lateinit var binding: FragmentProjectsBinding
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_projects, container, false)
        binding = FragmentProjectsBinding.bind(view)

        val homeListArray = resources.getStringArray(R.array.project_items).toList()
        adapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_1, homeListArray)
        adapter.setNotifyOnChange(true)
        binding.listProjects.adapter = adapter

        binding.listProjects.setOnItemClickListener { parent, view, position, id ->
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
        DialogHelper(binding.root.context, "Add", "Add new Project Item").createDialog("") {
            adapter.add(it)
        }
    }
}