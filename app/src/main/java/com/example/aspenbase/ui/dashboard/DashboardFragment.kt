package com.example.aspenbase.ui.dashboard

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.aspenbase.R
import com.example.aspenbase.databinding.FragmentDashboardBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding

    private var adapter: TabLayoutAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initListener()
    }

    private fun initListener() {
        binding?.run {
            // Handle tab selection changes
            tabLayoutHome.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    tab?.let {
                        viewPageHome.currentItem = it.position
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
            viewPageHome.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    tabLayoutHome.selectTab(tabLayoutHome.getTabAt(position))
                }
            })

            viewPageHome.let {
                TabLayoutMediator(tabLayoutHome, it) { tab, position ->
                    tab.text = getTabTitle(position) // Replace with your tab title logic
                }.attach()
            }

//            tvExplore.text = setBoldSpannable("Hello world to day, I am a bestfriend")
        }
    }

    private fun initView() {
        binding?.run {
            // Initialize TabLayoutAdapter
            adapter = TabLayoutAdapter(childFragmentManager, lifecycle)

            // Set adapter to ViewPager2
            viewPageHome.adapter = adapter
            // Add tabs dynamically based on adapter count
            for (i in 0 until (adapter?.itemCount ?: 0)) {
                tabLayoutHome.addTab(tabLayoutHome.newTab().setText(getTabTitle(i)))
            }
        }
    }

    private fun getTabTitle(position: Int): String {
        return when (position) {
            0 -> getString(R.string.location)
            1 -> getString(R.string.hotel)
            2 -> getString(R.string.food)
            3 -> getString(R.string.adventure)
            4 -> getString(R.string.visit)
            else -> getString(R.string.tabPosition, position)
        }
    }

    private fun setBoldSpannable(myText: String): SpannableString {
        var truncatedText = if (myText.length > 20) {
            myText.substring(0, 100) + "..."
        } else {
            myText
        }
//
//        val spannableContent = SpannableString(truncatedText)
//        spannableContent.setSpan(StyleSpan(Typeface.BOLD), 0, truncatedText.length / 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        val spannableContent = SpannableString(truncatedText)
        return spannableContent
    }


}