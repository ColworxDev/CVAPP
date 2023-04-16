package com.example.cvapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cvapp.R
import com.example.cvapp.adapter.SkillAdapter
import com.example.cvapp.databinding.FragmentSkillsBinding
import com.example.cvapp.model.Skill
import com.example.cvapp.other.Constants
import com.example.cvapp.other.DialogHelper


class SkillsFragment : BaseFragment() {

    private lateinit var binding: FragmentSkillsBinding
    private lateinit var adapter: SkillAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = inflater.inflate(R.layout.fragment_skills, container, false)
        binding = FragmentSkillsBinding.bind(rootView)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SkillAdapter(
            onSkillClick = { skill ->
                DialogHelper(
                    ctx,
                    getStringWith(R.string.text_cancel),
                    "${getStringWith(R.string.text_delete_note)} \n$skill"
                ).createDialogConfirm { confirm ->
                    if (confirm) {
                        adapter.remove(skill)
                    }
                }
            }
        )
        binding.rvSkill.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSkill.adapter = adapter

        val skills = getStringArrayWith(R.array.skills_items)
        val levels = getStringArrayWith(R.array.skills_levels).map { it.toFloatOrNull() ?: 0f }
        buildList {
            for (i in skills.indices) {
                add(Skill(skills[i], levels[i]))
            }
        }.let(adapter::submitList)

        setFragmentResultListener(Constants.REQUEST_KEY_ADD_SKILL) { _, bundle ->
            (bundle.getSerializable(Constants.BUNDLE_SKILL) as? Skill)?.let(adapter::add)
        }
    }

    override fun onClickFAB() {
        AddSkillDialogFragment().show(
            parentFragmentManager,
            AddSkillDialogFragment::class.simpleName
        )
    }
}