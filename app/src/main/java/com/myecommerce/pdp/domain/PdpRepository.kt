package com.myecommerce.pdp.domain

import com.myecommerce.pdp.domain.model.ProductModel

/**
 * Created by Amro, Abd-Elgawwad on 09/11/2020.
 */
interface PdpRepository {
    fun getArticle(articleId: String): ProductModel?
}