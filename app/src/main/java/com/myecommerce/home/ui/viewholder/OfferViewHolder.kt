package com.myecommerce.home.ui.viewholder

import android.view.ViewGroup
import com.myecommerce.R
import com.myecommerce.base.ktx.inflateDataBinding
import com.myecommerce.base.ui.recyclerview.viewholder.AbstractBindingViewHolder
import com.myecommerce.databinding.ViewPromotionBinding
import com.myecommerce.home.ui.model.UIOfferModel
import com.myecommerce.home.ui.viewModel.HomeViewModel

/**
 * Created by Amro, Abd-Elgawwad on 03/11/2020.
 */
class OfferViewHolder private constructor(
    binding: ViewPromotionBinding,
    viewModel: HomeViewModel
) : AbstractBindingViewHolder<UIOfferModel, ViewPromotionBinding>(binding) {

    init {
        binding.viewModel = viewModel
    }

    override fun bindModel(model: UIOfferModel) {
        binding.model = model
    }

    companion object {
        fun create(parent: ViewGroup, viewModel: HomeViewModel) = OfferViewHolder(
            inflateDataBinding(
                parent,
                R.layout.view_promotion
            ),
            viewModel
        )
    }
}