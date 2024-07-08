package com.example.aspenbase.ui.main.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.aspenbase.R
import com.example.aspenbase.databinding.FragmentDetailBinding
import com.example.aspenbase.ui.main.HomeActivity
import com.example.aspenbase.ui.main.adapter.CardItem


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding?.imageButtonBack?.setOnClickListener {
            (activity as HomeActivity).run {
                parentFragmentManager.popBackStack()
            }
        }

        arguments?.let { bundle ->
            val title = bundle.getString("title")
            val imageRes = bundle.getInt("imageRes")
            val rating = bundle.getDouble("rating")
            val isFavorite = bundle.getBoolean("isFavorite")
            val drawable = ContextCompat.getDrawable(requireContext(), imageRes)

            binding?.run {
                tvTitle.text = title
                tvRating.text = rating.toString()
                ivCard.setImageDrawable(drawable)
                imageButtonFavorite.setImageResource(
                    if (isFavorite) R.drawable.baseline_favorite
                    else R.drawable.baseline_favorite_border
                )
            }
        }


        binding?.run {
            tvReadMore?.setOnClickListener {
                if (tvDescription.maxLines == 3) {
                    // Expand the TextView to show full description
                    tvDescription.maxLines = 100
                    tvReadMore.text = "Read less"
                } else {
                    // Collapse the TextView to show only 3 lines
                    tvDescription.maxLines = 3
                    tvReadMore.text = "Read more"
                }
            }

            tvDescription.post {
                if (tvDescription.lineCount > 3) {
                    // Show "Read more" link
                    tvReadMore.visibility = View.VISIBLE
                } else {
                    // Hide "Read more" link if not needed
                    tvReadMore.visibility = View.GONE
                }
            }
        }
    }

    companion object {
        fun newInstance(item: CardItem): DetailFragment {
            val fragment = DetailFragment()
            val bundle = Bundle().apply {
                putString("title", item.title)
                putInt("imageRes", item.imageRes)
                putDouble("rating", item.rating)
                putBoolean("isFavorite", item.isFavorite)
            }
            fragment.arguments = bundle
            return fragment
        }
    }
}