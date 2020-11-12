package com.myecommerce.search.domain

import com.myecommerce.search.domain.model.ProductResultModel

/**
 * Created by Amro, Abd-Elgawwad on 09/11/2020.
 */
interface SearchRepository {
    fun getResults(searchText: String) : List<ProductResultModel>
}