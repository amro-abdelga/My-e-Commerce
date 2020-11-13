package com.myecommerce.pdp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.myecommerce.R
import com.myecommerce.base.ui.Notifier
import com.myecommerce.databinding.FragmentPdpBinding
import com.myecommerce.pdp.ui.viewmodel.PdpViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Amro, Abd-Elgawwad on 07/11/2020.
 */
@AndroidEntryPoint
class PdpFragment : Fragment() {


    private val viewModel: PdpViewModel by viewModels()

    private lateinit var binding: FragmentPdpBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPdpBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getArticleById(navArgs<PdpFragmentArgs>().value.articleId)
        viewModel.command.observe(viewLifecycleOwner) { event ->
            event?.peekContent()?.let { command ->
                if (command is PdpFragmentCommand.FavButtonClicked)
                    sendMemo(command.name)
            }
        }
    }

    private fun sendMemo(articleName: String) {
        val actualId = navArgs<PdpFragmentArgs>().value.articleId
        val arg = PdpFragmentArgs(actualId).toBundle()
        val pendingIntent = findNavController()
                .createDeepLink()
                .setDestination(R.id.pdpFragment)
                .setArguments(arg)
                .createPendingIntent()

        Notifier.postNotification(actualId, context, articleName, pendingIntent)
    }
}