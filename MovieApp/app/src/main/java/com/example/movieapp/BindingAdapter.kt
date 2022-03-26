package com.example.movieapp

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun load(imageView: ImageView, url: String?){
        if(url.isNullOrEmpty().not()){
            Glide.with(imageView.context).load(url).into(imageView)
        }
    }
}