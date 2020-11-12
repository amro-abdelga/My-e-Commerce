package com.myecommerce.search.ui.mapper

import com.myecommerce.search.domain.model.ProductResultModel
import com.myecommerce.search.ui.model.UISearchResultModel

/**
 * Created by Amro, Abd-Elgawwad on 09/11/2020.
 */

fun ProductResultModel.toUISearchResultModel() = UISearchResultModel(
    articleId = articleId,
    articleName = articleName,
    imageUrl = imageUrl,
    price = price,
    currency = currency
)