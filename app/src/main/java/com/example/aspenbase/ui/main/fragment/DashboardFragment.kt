package com.example.aspenbase.ui.main.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.aspenbase.R
import com.example.aspenbase.ui.main.adapter.TabLayoutAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class DashboardFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: TabLayoutAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabLayout = view.findViewById(R.id.tabLayoutHome)
        viewPager2 = view.findViewById(R.id.viewPageHome)

        // Initialize TabLayoutAdapter
        adapter = TabLayoutAdapter(childFragmentManager, lifecycle)

        // Set adapter to ViewPager2
        viewPager2.adapter = adapter

        // Add tabs dynamically based on adapter count
        for (i in 0 until adapter.itemCount) {
            tabLayout.addTab(tabLayout.newTab().setText(getTabTitle(i)))
        }

        // Handle tab selection changes
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    viewPager2.currentItem = it.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Not needed for this implementation
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Not needed for this implementation
            }
        })

        // Sync ViewPager2 with TabLayout on page changes
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = getTabTitle(position) // Replace with your tab title logic
        }.attach()
    }

    private fun getTabTitle(position: Int): String {
        return when (position) {
            0 -> "Locations"
            1 -> "Hotels"
            2 -> "Food"
            3 -> "Adventure"
            4 -> "Visit"
            else -> "Tab $position"
        }
    }
}