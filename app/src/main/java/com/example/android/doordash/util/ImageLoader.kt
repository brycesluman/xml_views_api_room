package com.example.android.doordash.util

import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

open class ImageLoader {
    fun loadImage(fragment: Fragment, url: String, view: ImageView) {
        Glide.with(fragment)
            .load(url)
            .into(view)
    }
}