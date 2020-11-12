package com.myecommerce.base.ui.recyclerview.viewholder

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.myecommerce.base.ui.recyclerview.model.RecyclerViewModel
import kotlinx.android.extensions.LayoutContainer

/**
 * Created by Amro, Abd-Elgawwad on 03/11/2020.
 */
abstract class AbstractBindingViewHolder<RVM : RecyclerViewModel, VDB : ViewDataBinding>(
    val binding: VDB
) : RecyclerView.ViewHolder(binding.root), LayoutContainer {

    override val containerView: View? = binding.root

    @Suppress("UNCHECKED_CAST")
    fun bindModel(model: Any) {
        bindModel(model as RVM)
    }

    protected abstract fun bindModel(model: RVM)

    open fun onAttachedToWindow() {}

    open fun onDetachedToWindow() {}

}