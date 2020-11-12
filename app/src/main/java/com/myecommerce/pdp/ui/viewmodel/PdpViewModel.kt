package com.myecommerce.pdp.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myecommerce.pdp.domain.PdpRepository
import dagger.hilt.android.scopes.FragmentScoped

/**
 * Created by Amro, Abd-Elgawwad on 07/11/2020.
 */
@FragmentScoped
class PdpViewModel @ViewModelInject constructor(
    private val repository: PdpRepository,
) : ViewModel() {
    private val _articleName = MutableLiveData<String>()
    val articleName: LiveData<String>
        get() = _articleName

    private val _price = MutableLiveData<String>()
    val price: LiveData<String>
        get() = _price

    private val _description = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _description

    private val _imageUrl = MutableLiveData<String>()
    val imageUrl: LiveData<String>
        get() = _imageUrl

    fun getArticleById(articleId: String?) {
        articleId?.let {
            val productModel = repository.getArticle(articleId)
            _articleName.value = productModel?.name
            _price.value = "${productModel?.price}${productModel?.currency}"
            _description.value = productModel?.description
            _imageUrl.value = productModel?.imagesUrl?.firstOrNull()
        }

    }
}