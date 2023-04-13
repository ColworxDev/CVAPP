package com.example.cvapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.viewpager2.widget.ViewPager2
import com.example.cvapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

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
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        // Whatever you typed to search the content, will be received using SearchManager object
        //   val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        // get the currently set action view for this menu item which returns View and cast it as a SearchView
        //val searchView = menu.findItem(R.id.menu_item_search).actionView as SearchView
        // Set Search bar hint
        //searchView.queryHint= "Search name"
        // Gets information about a searchable activity (Activity exist, searchable activity or null)
        // Direct the SearchView to the activity that will get the result
        // searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        // Listener to perform the search based on the types text
        //searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }
}