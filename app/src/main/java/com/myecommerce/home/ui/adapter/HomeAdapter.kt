package com.myecommerce.home.ui.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.myecommerce.base.ui.recyclerview.viewholder.AbstractBindingViewHolder
import com.myecommerce.home.ui.model.UIBaseHomeElementModel
import com.myecommerce.home.ui.viewModel.HomeViewModel
import com.myecommerce.home.ui.viewholder.OfferViewHolder

/**
 * Created by Amro, Abd-Elgawwad on 03/11/2020.
 */
class HomeAdapter (
    private val viewModel: HomeViewModel
) : ListAdapter<UIBaseHomeElementModel, AbstractBindingViewHolder<*, *>>(ItemCallBack()) {
    class ItemCallBack : DiffUtil.ItemCallback<UIBaseHomeElementModel>() {
        override fun areItemsTheSame(
            oldItem: UIBaseHomeElementModel,
            newItem: UIBaseHomeElementModel
        ) = oldItem.javaClass == newItem.javaClass

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: UIBaseHomeElementModel,
            newItem: UIBaseHomeElementModel
        ) = oldItem == newItem
    }

    override fun getItemViewType(position: Int) = getItem(position).type.ordinal

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbstractBindingViewHolder<*, *> = OfferViewHolder.create(parent, viewModel)

    override fun onBindViewHolder(holder: AbstractBindingViewHolder<*, *>, position: Int) {
        holder.bindModel(getItem(position))
        holder.binding.executePendingBindings()
    }

}