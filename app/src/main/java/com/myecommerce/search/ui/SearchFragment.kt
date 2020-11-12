package com.myecommerce.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.myecommerce.databinding.FragmentSearchBinding
import com.myecommerce.search.ui.adapter.SearchAdapter
import com.myecommerce.search.ui.model.SearchCommand
import com.myecommerce.search.ui.model.UISearchResultModel
import com.myecommerce.search.ui.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * Created by Amro, Abd-Elgawwad on 05/11/2020.
 */
@AndroidEntryPoint
class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModels()
    private lateinit var binding: FragmentSearchBinding
    private val adapter: SearchAdapter by lazy {
        SearchAdapter(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        recyclerView.adapter = adapter
        viewModel.articles.observe(this.viewLifecycleOwner, {
            onArticlesReceived(it.getContentIfNotHandled())
        })

        viewModel.command.observe(this.viewLifecycleOwner, {
            execCommand(it.getContentIfNotHandled())
        })
    }

    private fun execCommand(command: SearchCommand?) {
        when (command) {
            is SearchCommand.OpenPdp -> openPdp(command.articleId)
            else -> {

            }
        }
    }

    private fun openPdp(articleId: String) {
        val action = SearchFragmentDirections.actionSearchDialogFragmentToPdpFragment(articleId)
        findNavController().navigate(action)
    }

    private fun onArticlesReceived(list: List<UISearchResultModel>?) {
        adapter.submitList(list)
    }
}