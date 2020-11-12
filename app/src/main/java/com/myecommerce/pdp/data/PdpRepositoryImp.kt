package com.myecommerce.pdp.data

import com.myecommerce.pdp.data.local.PdpLocalDataSource
import com.myecommerce.pdp.domain.PdpRepository
import com.myecommerce.pdp.domain.model.ProductModel
import javax.inject.Inject

/**
 * Created by Amro, Abd-Elgawwad on 09/11/2020.
 */

class PdpRepositoryImp @Inject constructor(
    private val localDataSource: PdpLocalDataSource
): PdpRepository{
    override fun getArticle(articleId: String): ProductModel? = localDataSource.getArticle(articleId)

}