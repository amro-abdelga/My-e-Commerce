package com.myecommerce.search.data.local

import com.myecommerce.search.domain.model.ProductResultModel
import javax.inject.Inject

/**
 * Created by Amro, Abd-Elgawwad on 09/11/2020.
 */
class SearchLocalDataSourceImp @Inject constructor() : SearchLocalDataSource {
    private val localCache: List<ProductResultModel> = listOf(
        ProductResultModel(
            articleId = "1",
            articleName = "Ribbed chain-detail body",
            imageUrl = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D,source%5B/43/b9/43b944584627228985e22f90918c33626d6c0940.jpg%5D,origin%5Bdam%5D,category%5Bladies_tops_bodys%5D,type%5BLOOKBOOK%5D,res%5Bl%5D,hmver%5B1%5D&call=url%5Bfile:/product/cart%5D",
            price = 17.99,
            currency = "€",
        ),
        ProductResultModel(
            articleId = "2",
            articleName = "Cropped bow-front top",
            imageUrl = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D,source%5B/da/63/da63be9b61d25530bbb15c7d0d5b076ff9d31474.jpg%5D,origin%5Bdam%5D,category%5Bladies_tops%5D,type%5BLOOKBOOK%5D,res%5Bl%5D,hmver%5B1%5D&call=url%5Bfile:/product/main%5D",
            price = 9.99,
            currency = "€",
        ),
        ProductResultModel(
            articleId = "3",
            articleName = "Cotton T-Shirt",
            imageUrl = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D,source%5B/06/af/06afb43f7965b3310682da3ff04abb39f173e49c.jpg%5D,origin%5Bdam%5D,category%5Bladies_basics_tops_shortsleeve%5D,type%5BDESCRIPTIVESTILLLIFE%5D,res%5Bl%5D,hmver%5B1%5D&call=url%5Bfile:/product/main%5D",
            price = 6.99,
            currency = "€",
        )
    )

    override fun getResults(searchText: String): List<ProductResultModel> =
        if (searchText.toLowerCase() == "top") localCache else emptyList()
}