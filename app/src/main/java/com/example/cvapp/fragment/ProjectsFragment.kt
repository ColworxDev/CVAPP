package com.example.cvapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.cvapp.R
import com.example.cvapp.databinding.FragmentProjectsBinding
import com.example.cvapp.other.DialogHelper


class ProjectsFragment : BaseFragment() {

    private lateinit var binding: FragmentProjectsBinding
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_projects, container, false)
        binding = FragmentProjectsBinding.bind(rootView)

        val homeListArray = getStringArrayWith(R.array.project_items)
        adapter = ArrayAdapter(ctx, android.R.layout.simple_list_item_1, homeListArray)
        adapter.setNotifyOnChange(true)
        binding.listProjects.adapter = adapter

        binding.listProjects.setOnItemClickListener { parent, view, position, id ->
            var item = adapter.getItem(position)!!

            DialogHelper(
                ctx,
                getStringWith(R.string.text_confirm),
                "${getStringWith(R.string.text_delete_note)} \n$item"
            ).createDialogConfirm {
                if (it) {
                    adapter.remove(item)
                }
            }
        }
        return rootView
    }

    override fun onClickFAB() {
        DialogHelper(ctx, getStringWith(R.string.text_add), getStringWith(R.string.text_add_project_note)).createDialog("") {
            adapter.add(it)
        }
    }
}