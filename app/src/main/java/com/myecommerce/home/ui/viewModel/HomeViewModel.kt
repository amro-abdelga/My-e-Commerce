package com.myecommerce.home.ui.viewModel

import androidx.lifecycle.ViewModel
import com.myecommerce.home.ui.model.UIOfferModel

/**
 * Created by Amro, Abd-Elgawwad on 01/11/2020.
 */
class HomeViewModel : ViewModel() {
    fun getElement(department: String) = listOf(
        UIOfferModel(
            offersId = department,
            title = "$department - SPECIAL\nPRICES",
            buttonText = "VIEW"
        ),
        UIOfferModel(
            offersId = department,
            title = "$department - NEW\nCOLLECTION",
            buttonText = "VIEW"
        ),
    )

}