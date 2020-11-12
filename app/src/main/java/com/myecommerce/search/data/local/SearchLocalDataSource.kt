package com.myecommerce.search.data.local

import com.myecommerce.search.domain.model.ProductResultModel

/**
 * Created by Amro, Abd-Elgawwad on 09/11/2020.
 */
interface SearchLocalDataSource {
    fun getResults(searchText: String) : List<ProductResultModel>
}