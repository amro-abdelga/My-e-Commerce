package com.myecommerce.pdp.domain.model

/**
 * Created by Amro, Abd-Elgawwad on 09/11/2020.
 */
data class ProductModel(
    val articleId: String,
    val name: String,
    val description: String,
    val imagesUrl: List<String>,
    val price: Double,
    val currency: String,
    val sizes: List<String>
)