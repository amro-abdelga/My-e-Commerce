package com.myecommerce.search.ui.viewmodel

import androidx.databinding.ObservableField
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myecommerce.base.ui.Event
import com.myecommerce.base.ui.event
import com.myecommerce.search.domain.SearchRepository
import com.myecommerce.search.ui.mapper.toUISearchResultModel
import com.myecommerce.search.ui.model.SearchCommand
import com.myecommerce.search.ui.model.UISearchResultModel

/**
 * Created by Amro, Abd-Elgawwad on 05/11/2020.
 */
class SearchViewModel @ViewModelInject constructor(
    private val repository: SearchRepository
) : ViewModel() {

    var selectedCategory = ObservableField("WOMAN")

    private val _articles = MutableLiveData<Event<List<UISearchResultModel>>>()
    val articles: LiveData<Event<List<UISearchResultModel>>>
        get() = _articles

    private val _command = MutableLiveData<Event<SearchCommand>>()
    val command: LiveData<Event<SearchCommand>>
        get() = _command

    fun selectedArticle(model: UISearchResultModel) {
        _command.event(SearchCommand.OpenPdp(model.articleId))
    }

    fun onCategorySelected(category: String) {
        selectedCategory.set(category)
    }

    fun onSearchTextChanged(searchText: CharSequence?) {
        searchText?.toString()?.run {
            _articles.event(getArticles(this))
        }
    }

    private fun getArticles(searchText: String) = repository.getResults(searchText).map { it.toUISearchResultModel() }


}