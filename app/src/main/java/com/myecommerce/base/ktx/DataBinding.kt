package com.myecommerce.base.ktx

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.databinding.ViewDataBinding
import com.squareup.picasso.Picasso

/**
 * Created by Amro, Abd-Elgawwad on 31/10/2020.
 */

inline fun <reified T : Observable> T.observe(crossinline callBack: (sender: T) -> Unit) {
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            sender?.let { callBack((it as T)) }
        }
    })
}

fun <T : ViewDataBinding> inflateDataBinding(parent: ViewGroup?, @LayoutRes layoutId: Int) =
    DataBindingUtil.inflate<T>(
        LayoutInflater.from(parent?.context),
        layoutId,
        parent,
        false
    )

@BindingAdapter(
    value = ["imageUrl"],
    requireAll = false
)
fun setImageUrl(imageView: AppCompatImageView, url: String?) {
    url?.let {
        var loadUrl = url
        if (!url.contains("https")) {
            loadUrl = url.replace("http", "https")
        }
        Picasso.get().load(loadUrl).into(imageView)
    }
}