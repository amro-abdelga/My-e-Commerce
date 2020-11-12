package com.myecommerce.pdp.data.local

import com.myecommerce.pdp.domain.model.ProductModel
import javax.inject.Inject

/**
 * Created by Amro, Abd-Elgawwad on 09/11/2020.
 */
class PdpLocalDataSourceImp @Inject constructor() : PdpLocalDataSource {
    private val localCache: Map<String, ProductModel> = mapOf(
        Pair(
            "1",
            ProductModel(
                articleId = "1",
                name = "Ribbed chain-detail body",
                description = "Long-sleeved body in ribbed viscose jersey with a low-cut back decorated with a chain, and concealed press-studs at the crotch.",
                imagesUrl = listOf(
                    "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D,source%5B/43/b9/43b944584627228985e22f90918c33626d6c0940.jpg%5D,origin%5Bdam%5D,category%5Bladies_tops_bodys%5D,type%5BLOOKBOOK%5D,res%5Bl%5D,hmver%5B1%5D&call=url%5Bfile:/product/cart%5D",
                    "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D,source%5B/cf/29/cf29cb79046679704d9cd3e2bd88f57da7ae0a91.jpg%5D,origin%5Bdam%5D,category%5Bladies_tops_bodys%5D,type%5BLOOKBOOK%5D,res%5Bm%5D,hmver%5B1%5D&call=url%5Bfile:/product/main%5D",
                    "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D,source%5B/99/9e/999eb88b7ed24cc649c7dbb147346bdae8defc8d.jpg%5D,origin%5Bdam%5D,category%5Bladies_tops_bodys%5D,type%5BDESCRIPTIVESTILLLIFE%5D,res%5Bm%5D,hmver%5B1%5D&call=url%5Bfile:/product/main%5D"
                ),
                price = 17.99,
                currency = "€",
                sizes = listOf("L", "M", "S")
            )
        ),
        Pair(
            "2",
            ProductModel(
                articleId = "2",
                name = "Cropped bow-front top",
                description = "Cropped top in taffeta with a large, decorative bow at the front, narrow, adjustable shoulder straps and a smocked section at the back. Lined at the front.",
                imagesUrl = listOf(
                    "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D,source%5B/da/63/da63be9b61d25530bbb15c7d0d5b076ff9d31474.jpg%5D,origin%5Bdam%5D,category%5Bladies_tops%5D,type%5BLOOKBOOK%5D,res%5Bl%5D,hmver%5B1%5D&call=url%5Bfile:/product/main%5D",
                    "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D,source%5B/14/61/14615f60043bb9f593a1f9c7b237bda01f8e43e8.jpg%5D,origin%5Bdam%5D,category%5Bladies_tops%5D,type%5BLOOKBOOK%5D,res%5Bm%5D,hmver%5B1%5D&call=url%5Bfile:/product/main%5D",
                    "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D,source%5B/13/d4/13d4138cd7ac9eddea1814260f59e20e96b79ac5.jpg%5D,origin%5Bdam%5D,category%5Bladies_tops%5D,type%5BDESCRIPTIVESTILLLIFE%5D,res%5Bl%5D,hmver%5B1%5D&call=url%5Bfile:/product/main%5D"
                ),
                price = 9.99,
                currency = "€",
                sizes = listOf("L", "M", "S")
            )
        ),
        Pair(
            "3",
            ProductModel(
                articleId = "3",
                name = "Cotton T-Shirt",
                description = "Long T-shirt in cotton jersey. Relaxed fit with dropped shoulders and short sleeves with sewn-in turn-ups.",
                imagesUrl = listOf(
                    "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D,source%5B/06/af/06afb43f7965b3310682da3ff04abb39f173e49c.jpg%5D,origin%5Bdam%5D,category%5Bladies_basics_tops_shortsleeve%5D,type%5BDESCRIPTIVESTILLLIFE%5D,res%5Bl%5D,hmver%5B1%5D&call=url%5Bfile:/product/main%5D"
                ),
                price = 6.99,
                currency = "€",
                sizes = listOf("L", "M", "S")
            )
        )
    )

    override fun getArticle(articleId: String): ProductModel? = localCache[articleId]

}