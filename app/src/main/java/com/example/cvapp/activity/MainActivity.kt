package com.example.cvapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.example.cvapp.adapter.MyPageAdapter
import com.example.cvapp.R
import com.example.cvapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myPageAdapter = MyPageAdapter(this)
        // Set the Adapter to your Viewpager UI
        binding.vpager.adapter = myPageAdapter
        // Will align the space according to the Screen size to equally spread
        binding.tlayout.tabGravity = TabLayout.GRAVITY_FILL

        binding.tlayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {

                binding.vpager.currentItem = tab!!.position
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Handle tab reselect
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselect
            }
        })
        // According to the Swipe Tabs also associated - Need this callback
        binding.vpager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                //   super.onPageSelected(position)
                // Select the Tab added to the ActionBar
                binding.tlayout.getTabAt(position)!!.select()
            }
        })

        binding.fab.setOnClickListener {
            print("fab pressed")
        }
    }

    private fun setCurrentFragment() {
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.tlayout,
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu):Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

}