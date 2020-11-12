package com.myecommerce.pdp.data.local

import com.myecommerce.pdp.domain.model.ProductModel

/**
 * Created by Amro, Abd-Elgawwad on 09/11/2020.
 */
interface PdpLocalDataSource {
    fun getArticle(articleId: String): ProductModel?
}