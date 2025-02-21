package com.example.aspenbase.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.aspenbase.ui.main.fragment.AdventureFragment
import com.example.aspenbase.ui.main.fragment.FoodFragment
import com.example.aspenbase.ui.main.fragment.HotelFragment
import com.example.aspenbase.ui.main.fragment.LocationFragment
import com.example.aspenbase.ui.main.fragment.VisitFragment

class TabLayoutAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LocationFragment();
            1 -> HotelFragment();
            2 -> FoodFragment();
            3 -> AdventureFragment();
            4 -> VisitFragment();
            else -> LocationFragment()
        }
    }
}
