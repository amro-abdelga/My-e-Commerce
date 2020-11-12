package com.myecommerce.search.ui.viewholder

import android.view.ViewGroup
import com.myecommerce.R
import com.myecommerce.base.ktx.inflateDataBinding
import com.myecommerce.base.ui.recyclerview.viewholder.AbstractBindingViewHolder
import com.myecommerce.databinding.ViewSearchResultBinding
import com.myecommerce.search.ui.model.UISearchResultModel
import com.myecommerce.search.ui.viewmodel.SearchViewModel

/**
 * Created by Amro, Abd-Elgawwad on 05/11/2020.
 */
class SearchResultViewHolder private constructor(
    binding: ViewSearchResultBinding,
    viewModel: SearchViewModel
) : AbstractBindingViewHolder<UISearchResultModel, ViewSearchResultBinding>(binding) {

    init {
        binding.viewModel = viewModel
    }

    override fun bindModel(model: UISearchResultModel) {
        binding.model = model
    }

    companion object {
        fun create(parent: ViewGroup, viewModel: SearchViewModel) = SearchResultViewHolder(
            inflateDataBinding(
                parent,
                R.layout.view_search_result
            ),
            viewModel
        )
    }
}