package com.myecommerce.search.domain.model

/**
 * Created by Amro, Abd-Elgawwad on 09/11/2020.
 */
data class ProductResultModel(
    val articleId: String,
    val articleName: String,
    val imageUrl: String,
    val price: Double,
    val currency: String
)