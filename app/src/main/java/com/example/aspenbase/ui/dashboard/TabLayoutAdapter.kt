package com.example.aspenbase.ui.dashboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.aspenbase.ui.dashboard.fragment.AdventureFragment
import com.example.aspenbase.ui.dashboard.fragment.FoodFragment
import com.example.aspenbase.ui.dashboard.fragment.HotelFragment
import com.example.aspenbase.ui.dashboard.fragment.LocationFragment
import com.example.aspenbase.ui.dashboard.fragment.VisitFragment

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
