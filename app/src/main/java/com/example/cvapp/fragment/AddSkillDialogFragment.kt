package com.example.cvapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import com.example.cvapp.R
import com.example.cvapp.databinding.DiaglogFragmentAddSkillBinding
import com.example.cvapp.model.Skill
import com.example.cvapp.other.Constants

class AddSkillDialogFragment : DialogFragment() {

    private var _binding: DiaglogFragmentAddSkillBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.diaglog_fragment_add_skill, container, false)
            .apply {
                _binding = DiaglogFragmentAddSkillBinding.bind(this)
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnConfirm.setOnClickListener {
                val skill = tvSkill.text.toString()
                if (skill.isBlank()) {
                    Toast.makeText(requireContext(), R.string.error_skill_empty, Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val result = bundleOf(Constants.BUNDLE_SKILL to Skill(skill, rbLevel.rating))
                    setFragmentResult(Constants.REQUEST_KEY_ADD_SKILL, result)
                    dismiss()
                }
            }
            btnCancel.setOnClickListener {
                dismiss()
            }
        }
    }

    override fun onDestroyView() {
        _binding = null // to prevent memory leak
        super.onDestroyView()
    }
}