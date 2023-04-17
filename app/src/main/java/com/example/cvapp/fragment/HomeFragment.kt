package com.example.cvapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cvapp.R
import com.example.cvapp.adapter.EducationAdapter
import com.example.cvapp.databinding.FragmentHomeBinding
import com.example.cvapp.other.DialogHelper


class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: EducationAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(rootView)

        val homeListArray = getStringArrayWith(R.array.education_items)
        adapter = EducationAdapter(
            educations = homeListArray.toMutableList(),
            onItemClick = { item ->
                DialogHelper(
                    binding.root.context,
                    getStringWith(R.string.text_confirm),
                    "${getStringWith(R.string.text_delete_note)} \n$item"
                ).createDialogConfirm {
                    if (it) {
                        adapter.remove(item)
                    }
                }
            }
        )
        binding.rvEdu.adapter = adapter
        binding.rvEdu.layoutManager = LinearLayoutManager(requireContext())
        binding.textViewProfileTitle.setOnClickListener {
            DialogHelper(
                ctx,
                getStringWith(R.string.text_edit),
                getStringWith(R.string.text_edit_name_note)
            ).createDialog(binding.textViewProfileTitle.text.toString()) {
                binding.textViewProfileTitle.text = it
            }
        }

        binding.textViewProfileSubTitle.setOnClickListener {
            DialogHelper(
                ctx,
                getStringWith(R.string.text_edit),
                getStringWith(R.string.text_edit_profession_note)
            ).createDialog(binding.textViewProfileSubTitle.text.toString()) {
                binding.textViewProfileSubTitle.text = it
            }
        }

        binding.textViewAddress.setOnClickListener {
            DialogHelper(requireActivity(), getStringWith(R.string.text_edit), getStringWith(R.string.text_edit_address_note)).createDialog(binding.textViewAddress.text.toString()) {
                binding.textViewAddress.text = it
            }
        }


        binding.textViewPhone.setOnClickListener {
            DialogHelper(requireActivity(), getStringWith(R.string.text_edit), getStringWith(R.string.text_edit_phone_note)).createDialog(binding.textViewPhone.text.toString()) {
                binding.textViewPhone.text = it
            }
        }

        binding.textViewBio.setOnClickListener {
            DialogHelper(requireActivity(), getStringWith(R.string.text_edit), getStringWith(R.string.text_edit_bio_summary)).createDialog(binding.textViewBio.text.toString()) {
                binding.textViewBio.text = it
            }
        }

        return binding.root
    }

    override fun onClickFAB() {
        DialogHelper(ctx, getStringWith(R.string.text_add), getStringWith(R.string.text_add_edu_note)).createDialog("") {
            adapter.add(it)
        }
    }
}