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


class SkillsFragment : BaseFragment() {

    private lateinit var binding: FragmentSkillsBinding
    private lateinit var adapter: ArrayAdapter<String>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_skills, container, false)
        binding = FragmentSkillsBinding.bind(rootView)

        val homeListArray = getStringArrayWith(R.array.skills_items)
        adapter = ArrayAdapter(ctx, android.R.layout.simple_list_item_1, homeListArray)
        adapter.setNotifyOnChange(true)
        binding.listSkills.adapter = adapter

        binding.listSkills.setOnItemClickListener { parent, view, position, id ->
            var item = adapter.getItem(position)!!

            DialogHelper(
                ctx,
                getStringWith(R.string.text_cancel),
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
        DialogHelper(ctx, getStringWith(R.string.text_add), getStringWith(R.string.text_add_skill_note)).createDialog("") {
            adapter.add(it)
        }
    }

}