package com.myecommerce.search.ui.model

import com.myecommerce.base.ui.recyclerview.model.RecyclerViewModel

/**
 * Created by Amro, Abd-Elgawwad on 05/11/2020.
 */
data class UISearchResultModel(
    val articleId: String,
    val articleName: String,
    val price: Double,
    val imageUrl: String,
    val currency: String
) : RecyclerViewModel()