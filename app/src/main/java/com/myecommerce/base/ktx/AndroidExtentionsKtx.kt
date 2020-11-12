package com.myecommerce.base.ktx

import com.google.android.material.tabs.TabLayout

/**
 * Created by Amro, Abd-Elgawwad on 03/11/2020.
 */

fun TabLayout.onTabChanged(block: (tab: TabLayout.Tab?) -> Unit){
    addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            block(tab)
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {

        }

        override fun onTabReselected(tab: TabLayout.Tab?) {

        }
    })
}