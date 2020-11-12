package com.myecommerce.search.data

import com.myecommerce.search.data.local.SearchLocalDataSource
import com.myecommerce.search.domain.SearchRepository
import com.myecommerce.search.domain.model.ProductResultModel
import javax.inject.Inject

/**
 * Created by Amro, Abd-Elgawwad on 09/11/2020.
 */
class SearchRepositoryImp @Inject constructor(
    private val localDataSource: SearchLocalDataSource
) : SearchRepository {
    override fun getResults(searchText: String): List<ProductResultModel> =
        localDataSource.getResults(searchText)
}