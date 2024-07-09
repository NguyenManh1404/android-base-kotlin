package com.example.aspenbase.ui.dashboard.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aspenbase.R
import com.example.aspenbase.data.CardItem
import com.example.aspenbase.databinding.FragmentLocationBinding
import com.example.aspenbase.ui.HomeActivity
import com.example.aspenbase.ui.dashboard.CardAdapter


class LocationFragment : Fragment() {

    private var _binding: FragmentLocationBinding? = null
    private val binding get() = _binding
    private var popularList: MutableList<CardItem> = mutableListOf()
    private var myAdapter: CardAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        initListener()
    }

    private fun initView() {
        popularList.run {
            add(CardItem(R.drawable.img_danang, "Home Stay", 4.1, true))
            add(CardItem(R.drawable.bg_welcome, "Alley Place", 5.0, true))
            add(CardItem(R.drawable.img_danang, "Home Stay", 4.1, false))
            add(CardItem(R.drawable.bg_welcome, "Alley Place", 5.0, true))
            add(CardItem(R.drawable.img_danang, "Home Stay", 4.1))
            add(CardItem(R.drawable.bg_welcome, "Alley Place", 5.0))
            add(CardItem(R.drawable.img_danang, "Home Stay", 4.1))
            add(CardItem(R.drawable.bg_welcome, "Alley Place", 5.0))
        }


        binding?.recyclerViewPopular?.run {
            myAdapter = CardAdapter(popularList)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = myAdapter
        }

        myAdapter?.notifyDataSetChanged()
    }


    private fun initListener() {
        myAdapter?.onClickItem = {
            Toast.makeText(context, "Its a toast! $it.title", Toast.LENGTH_SHORT).show()

            (activity as HomeActivity).addDetailFragment(it)

        }

        myAdapter?.onClickFavorite = {
            Toast.makeText(context, "Its a toast! Favorite ${it.title}", Toast.LENGTH_SHORT).show()
        }


    }

}