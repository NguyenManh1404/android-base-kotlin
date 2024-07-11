package com.example.aspenbase.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aspenbase.R
import com.example.aspenbase.data.CardItem
import com.example.aspenbase.databinding.ActivityHomeBinding
import com.example.aspenbase.ui.dashboard.detail.DetailFragment
import com.example.aspenbase.ui.booking.BookingFragment
import com.example.aspenbase.ui.dashboard.DashboardFragment
import com.example.aspenbase.ui.favorite.FavoriteFragment
import com.example.aspenbase.ui.profile.ProfileFragment


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
    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

}