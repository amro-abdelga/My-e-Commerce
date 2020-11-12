package com.myecommerce.search.ui.model

/**
 * Created by Amro, Abd-Elgawwad on 07/11/2020.
 */
sealed class SearchCommand {
    data class OpenPdp(val articleId: String) : SearchCommand()
    object Exit : SearchCommand()
}