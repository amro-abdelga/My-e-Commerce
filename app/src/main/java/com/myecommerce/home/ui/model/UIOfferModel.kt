package com.myecommerce.home.ui.model

/**
 * Created by Amro, Abd-Elgawwad on 03/11/2020.
 */
data class UIOfferModel(
    val offersId: String,
    val title: String,
    val buttonText: String
): UIBaseHomeElementModel(HomeElementType.OFFER)