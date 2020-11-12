package com.myecommerce.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.myecommerce.R
import com.myecommerce.base.ktx.onTabChanged
import com.myecommerce.home.ui.adapter.HomeAdapter
import com.myecommerce.home.ui.viewModel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by Amro, Abd-Elgawwad on 31/10/2020.
 */
class HomeFragment : Fragment() {


    private val viewModel: HomeViewModel by viewModels()
    private val adapter: HomeAdapter by lazy {
        HomeAdapter(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        PagerSnapHelper().attachToRecyclerView(recyclerView)
        recyclerView.adapter = adapter

        adapter.submitList(
            viewModel.getElement(
                topBar.getTabAt(topBar.selectedTabPosition)?.text?.toString() ?: ""
            )
        )
        topBar.onTabChanged {
            adapter.submitList(viewModel.getElement(it?.text?.toString() ?: ""))
        }

    }

}