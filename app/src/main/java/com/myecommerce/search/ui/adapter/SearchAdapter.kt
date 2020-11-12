package com.myecommerce.search.ui.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.myecommerce.base.ui.recyclerview.model.RecyclerViewModel
import com.myecommerce.base.ui.recyclerview.viewholder.AbstractBindingViewHolder
import com.myecommerce.search.ui.viewholder.SearchResultViewHolder
import com.myecommerce.search.ui.viewmodel.SearchViewModel

/**
 * Created by Amro, Abd-Elgawwad on 05/11/2020.
 */
class SearchAdapter(
    private val viewModel: SearchViewModel
) : ListAdapter<RecyclerViewModel, AbstractBindingViewHolder<*, *>>(ItemCallBack()) {
    class ItemCallBack : DiffUtil.ItemCallback<RecyclerViewModel>() {
        override fun areItemsTheSame(
            oldItem: RecyclerViewModel,
            newItem: RecyclerViewModel
        ) = oldItem.javaClass == newItem.javaClass

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: RecyclerViewModel,
            newItem: RecyclerViewModel
        ) = oldItem == newItem
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbstractBindingViewHolder<*, *> = SearchResultViewHolder.create(parent, viewModel)

    override fun onBindViewHolder(holder: AbstractBindingViewHolder<*, *>, position: Int) {
        holder.bindModel(getItem(position))
        holder.binding.executePendingBindings()
    }

}