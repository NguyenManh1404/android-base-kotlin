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

    internal var onClickFavorite: ((CardItem) -> Unit) = {}


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
                if (adapterPosition != RecyclerView.NO_POSITION) {

                    val item = cardItemList[adapterPosition]
                    item.isFavorite = !item.isFavorite
                    onClickFavorite.invoke(item)
                    notifyItemChanged(adapterPosition)
                }
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

//data class CardItem(
//    val imageRes: Int,
//    val title: String,
//    val rating: Double,
//    var isFavorite: Boolean = false
//) : Parcelable {
//    constructor(parcel: Parcel) : this(
//        parcel.readInt(),
//        parcel.readString() ?: "",
//        parcel.readDouble(),
//        parcel.readByte() != 0.toByte()
//    )
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeInt(imageRes)
//        parcel.writeString(title)
//        parcel.writeDouble(rating)
//        parcel.writeByte(if (isFavorite) 1 else 0)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<CardItem> {
//        override fun createFromParcel(parcel: Parcel): CardItem {
//            return CardItem(parcel)
//        }
//
//        override fun newArray(size: Int): Array<CardItem?> {
//            return arrayOfNulls(size)
//        }
//    }
//}