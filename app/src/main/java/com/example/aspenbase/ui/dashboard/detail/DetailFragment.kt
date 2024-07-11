package com.example.aspenbase.ui.dashboard.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.aspenbase.R
import com.example.aspenbase.data.CardItem
import com.example.aspenbase.databinding.FragmentDetailBinding
import com.example.aspenbase.ui.HomeActivity


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding
    private var cardItem: CardItem? = null
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
        initView()
        initListener()
    }


    private fun initListener() {
        binding?.imageButtonBack?.setOnClickListener {
            (activity as HomeActivity).run {
                parentFragmentManager.popBackStack()
            }
        }

    }

    private  fun initView (){
        cardItem = arguments?.getParcelable(KEY_CARD_ITEM)

        cardItem?.run {
            val drawable = ContextCompat.getDrawable(requireContext(), imageRes)

            binding?.run {
                tvTitle.text = title
                tvRating.text = rating.toString()
                ivCard.setImageDrawable(drawable)
                imageButtonFavorite.setImageResource(
                    if (isFavorite) {
                        R.drawable.baseline_favorite
                    } else {
                        R.drawable.baseline_favorite_border
                    }
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

        private  const val  KEY_CARD_ITEM = "key_card_item"

        internal fun newInstance(item: CardItem): DetailFragment = DetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY_CARD_ITEM, item)
            }
        }
    }
}