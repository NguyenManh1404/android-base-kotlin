package com.example.aspenbase.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.aspenbase.R
import com.example.aspenbase.data.CardItem
import com.example.aspenbase.databinding.ItemPopularBinding

class CardAdapter(private val cardItemList: List<CardItem>) :
RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    internal var onClickItem: ((CardItem) -> Unit) = {}

    internal var onClickFavorite: ((position:Int) -> Unit) = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder =
        CardViewHolder(
            ItemPopularBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.onBind(cardItemList[position])
    }

    override fun getItemCount() = cardItemList.size

    inner class CardViewHolder(private val binding: ItemPopularBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.ivCard.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onClickItem.invoke(cardItemList[adapterPosition])
                }
            }
            binding.imageButtonFavorite.setOnClickListener {
               onClickFavorite(adapterPosition)
            }
        }

        fun onBind(cardItem: CardItem) {
            binding.run {
                ivCard.setImageDrawable(
                    ContextCompat.getDrawable(
                        itemView.context,
                        cardItem.imageRes
                    )
                )
                tvTitle.text = cardItem.title
                tvRating.text = cardItem.rating.toString()
                imageButtonFavorite.setImageResource(
                    if (cardItem.isFavorite) R.drawable.baseline_favorite
                    else R.drawable.baseline_favorite_border
                )
            }
        }
    }
}