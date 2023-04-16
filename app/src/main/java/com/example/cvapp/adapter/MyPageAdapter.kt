package com.example.cvapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cvapp.fragment.HomeFragment
import com.example.cvapp.fragment.ProjectsFragment
import com.example.cvapp.fragment.SkillsFragment
import com.example.cvapp.fragment.WorkFragment

class MyPageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    fun createFragments() {
        home = HomeFragment()
        skills = SkillsFragment()
        work = WorkFragment()
        projects = ProjectsFragment()
    }

    override fun getItemCount()=4

    private lateinit var home : HomeFragment
    private lateinit var skills : SkillsFragment
    private lateinit var work : WorkFragment
    private lateinit var projects : ProjectsFragment

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> home
            1 -> skills
            2 -> work
            3 -> projects
            else -> Fragment()
        }
    }

    fun onActionFAB(currentItem: Int) {
        when (currentItem) {
            0 -> home.onClickFAB()
            2 -> work.onClickFAB()
            3 -> projects.onClickFAB()
            else -> println("Do nothing")
        }
    }
}