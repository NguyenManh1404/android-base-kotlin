package com.example.aspenbase.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aspenbase.R
import com.example.aspenbase.databinding.ActivityHomeBinding
import com.example.aspenbase.ui.main.adapter.CardItem
import com.example.aspenbase.ui.main.detail.DetailFragment
import com.example.aspenbase.ui.main.fragment.BookingFragment
import com.example.aspenbase.ui.main.fragment.DashboardFragment
import com.example.aspenbase.ui.main.fragment.FavoriteFragment
import com.example.aspenbase.ui.main.fragment.ProfileFragment


class HomeActivity : AppCompatActivity() {

    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        goToFragment(DashboardFragment())


        binding?.bottomNavigation?.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottomHome -> {
                    goToFragment(DashboardFragment())
                }

                R.id.bottomBooking -> {
                    goToFragment(BookingFragment())
                }

                R.id.bottomFavor -> {
                    goToFragment(FavoriteFragment())
                }

                R.id.bottomProfile -> {
                    goToFragment(ProfileFragment())
                }
            }
            true
        }

    }


    private fun goToFragment(fragment: Fragment) {
        val commit =
            supportFragmentManager.beginTransaction().replace(R.id.frameContainerHome, fragment)
                .commit()
    }

    internal fun addDetailFragment(item: CardItem) {
        val fragment = DetailFragment.newInstance(item)
        supportFragmentManager.beginTransaction().add(R.id.frameContainer, fragment)
            .addToBackStack("home")
            .commit()
    }
}