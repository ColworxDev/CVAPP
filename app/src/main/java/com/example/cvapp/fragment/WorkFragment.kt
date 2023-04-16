package com.example.cvapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.cvapp.R
import com.example.cvapp.databinding.FragmentWorkBinding
import com.example.cvapp.other.DialogHelper

class WorkFragment : Fragment() {

    private lateinit var binding: FragmentWorkBinding
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_work, container, false)
        binding = FragmentWorkBinding.bind(view)

        val homeListArray = resources.getStringArray(R.array.work_history).toList()
        adapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_1, homeListArray)
        adapter.setNotifyOnChange(true)
        binding.listWork.adapter = adapter

        binding.listWork.setOnItemClickListener { parent, view, position, id ->
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
        DialogHelper(binding.root.context, "Add", "Add new Work Record").createDialog("") {
            adapter.add(it)
        }
    }
}