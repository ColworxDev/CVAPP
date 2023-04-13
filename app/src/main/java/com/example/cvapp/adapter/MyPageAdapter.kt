package com.example.cvapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cvapp.fragment.HomeFragment
import com.example.cvapp.fragment.ProjectsFragment
import com.example.cvapp.fragment.SkillsFragment
import com.example.cvapp.fragment.WorkFragment

class MyPageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount()=4
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> SkillsFragment()
            2 -> WorkFragment()
            3 -> ProjectsFragment()
            else -> Fragment()
        }
    }
}