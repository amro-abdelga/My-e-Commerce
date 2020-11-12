package com.myecommerce.search.ui.ktx

import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.TextViewCompat
import androidx.databinding.BindingAdapter
import com.myecommerce.R

/**
 * Created by Amro, Abd-Elgawwad on 05/11/2020.
 */

@BindingAdapter(
    value = ["selectedCategory"],
    requireAll = false
)
fun setIfSelected(textView: AppCompatTextView, category: String?) {
    if (textView.text.toString() == category) {
        TextViewCompat.setTextAppearance(textView, R.style.Body_Text_Bold)
    } else {
        TextViewCompat.setTextAppearance(textView, R.style.Body_Text)
    }
}