package com.example.dailydiamond.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailydiamond.R
import com.example.dailydiamond.databinding.LayoutIntroBinding

class IntroAdapter(var context: Activity) : RecyclerView.Adapter<IntroAdapter.ViewHolder>() {

    val list = arrayOf<Int>(
        R.drawable.img_intro_1,
        R.drawable.img_intro_2,
        R.drawable.img_intro_3
    )

    class ViewHolder(var binding : LayoutIntroBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutIntroBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            binding.introImage.setImageResource(list[position])
        }
    }
}