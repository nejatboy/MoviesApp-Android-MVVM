package com.newgamesoftware.moviesdemo_android_mvvm.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso


val Float.widthRatio: Int get() = (Device.width * this).toInt()
val Float.heightRatio: Int get() = (Device.height * this).toInt()


// ImageView
fun ImageView.loadUrl(path: String?) {
    Picasso.get().load(path).fit().into(this)
}


@BindingAdapter("android:loadUrl")
fun loadImageFromUrl(imageView: ImageView, url: String?) {
    imageView.loadUrl(path = url)
}