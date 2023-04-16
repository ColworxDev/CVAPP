package com.example.cvapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cvapp.fragment.*

class MyPageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    fun createFragments() {
        items = arrayOf(
            HomeFragment(),
            SkillsFragment(),
            WorkFragment(),
            ProjectsFragment()
        ).toList()
    }

    override fun getItemCount() = items.size

    private lateinit var items: List<BaseFragment>

    override fun createFragment(position: Int) = items[position]

    fun onActionFAB(currentItem: Int) {
        items[currentItem].onClickFAB()
    }
}