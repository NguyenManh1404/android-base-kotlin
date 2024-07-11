package com.example.aspenbase.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardItem(
    var imageRes: Int,
    var title: String,
    var rating: Double,
    var isFavorite: Boolean = false
): Parcelable