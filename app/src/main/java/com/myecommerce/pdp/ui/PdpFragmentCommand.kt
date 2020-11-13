package com.myecommerce.pdp.ui

/**
 * Created by Amro, Abd-Elgawwad on 13/11/2020.
 */
sealed class PdpFragmentCommand {
    data class FavButtonClicked(val name: String) : PdpFragmentCommand()
}