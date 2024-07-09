package com.example.aspenbase.data

data class CardItem(
    var imageRes: Int,
    var title: String,
    var rating: Double,
    var isFavorite: Boolean = false
)