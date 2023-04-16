package com.example.cvapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.cvapp.R
import com.example.cvapp.databinding.FragmentHomeBinding
import com.example.cvapp.other.DialogHelper


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home,container,false)
        binding = FragmentHomeBinding.bind(view)

        val homeListArray = resources.getStringArray(R.array.education_items).toList()
        adapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_1, homeListArray)
        adapter.setNotifyOnChange(true)
        binding.homeList.adapter = adapter

        binding.homeList.setOnItemClickListener { parent, view, position, id ->
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

        binding.textViewProfileTitle.setOnClickListener {
            DialogHelper(requireActivity(), "Edit", "Edit your full Name").createDialog(binding.textViewProfileTitle.text.toString()) {
                binding.textViewProfileTitle.text = it
            }
        }

        binding.textViewProfileSubTitle.setOnClickListener {
            DialogHelper(requireActivity(), "Edit", "Edit your profession").createDialog(binding.textViewProfileSubTitle.text.toString()) {
                binding.textViewProfileSubTitle.text = it
            }
        }

        binding.textViewAddress.setOnClickListener {
            DialogHelper(requireActivity(), "Edit", "Edit your Address").createDialog(binding.textViewAddress.text.toString()) {
                binding.textViewAddress.text = it
            }
        }


        binding.textViewPhone.setOnClickListener {
            DialogHelper(requireActivity(), "Edit", "Edit your Phone").createDialog(binding.textViewPhone.text.toString()) {
                binding.textViewPhone.text = it
            }
        }

        binding.textViewBio.setOnClickListener {
            DialogHelper(requireActivity(), "Edit", "Edit your Bio Summary").createDialog(binding.textViewBio.text.toString()) {
                binding.textViewBio.text = it
            }
        }

        return binding.root
    }

    fun onClickFAB() {
        DialogHelper(binding.root.context, "Add", "Add new Education Item").createDialog("") {
            adapter.add(it)
        }
    }
}