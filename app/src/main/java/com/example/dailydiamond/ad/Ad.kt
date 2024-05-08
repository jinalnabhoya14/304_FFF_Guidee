package com.example.dailydiamond.ad

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.dailydiamond.R
import com.example.dailydiamond.databinding.Ad170ImageBinding
import com.example.dailydiamond.databinding.Ad30Binding
import com.example.dailydiamond.databinding.Ad40Binding

val image = arrayOf(R.drawable.img_ad_1,R.drawable.img_ad_2,R.drawable.img_ad_3)
val bannerImage = arrayOf(R.drawable.img_ad_banner_1,R.drawable.img_ad_banner_2,R.drawable.img_ad_bottom_1,R.drawable.img_ad_bottom_2)

fun Context.ad170(viewGroup: ViewGroup){
    val layoutInflater: LayoutInflater = LayoutInflater.from(this)
    val binding = Ad170ImageBinding.inflate(layoutInflater)
    viewGroup.removeAllViews()
    viewGroup.addView(binding.root)
    binding.image.setImageResource(image.random())
}

fun Activity.adSmall(viewGroup: ViewGroup){
    val layoutInflater: LayoutInflater = LayoutInflater.from(this)
    val binding = Ad40Binding.inflate(layoutInflater)
    viewGroup.removeAllViews()
    viewGroup.addView(binding.root)
}

fun Context.adBanner(viewGroup: ViewGroup){
    val layoutInflater: LayoutInflater = LayoutInflater.from(this)
    val binding = Ad30Binding.inflate(layoutInflater)
    viewGroup.removeAllViews()
    viewGroup.addView(binding.root)
    binding.img.setImageResource(bannerImage.random())
}

