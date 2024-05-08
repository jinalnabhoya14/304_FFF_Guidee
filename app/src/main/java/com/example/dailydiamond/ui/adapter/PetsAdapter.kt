package com.example.dailydiamond.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailydiamond.databinding.LayoutPetsBinding
import com.example.dailydiamond.ui.model.Image

class PetsAdapter(var activity: Activity,var petList:ArrayList<Image>,var onClick:OnClick): RecyclerView.Adapter<PetsAdapter.ViewHolder>() {

    interface OnClick{
        fun onClick(position: Int,image: Int)
    }

    class ViewHolder (var binding: LayoutPetsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutPetsBinding.inflate(LayoutInflater.from(activity),parent,false))
    }

    override fun getItemCount(): Int {
        return petList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            binding.image.setImageResource(petList[position].image)
            binding.image.setOnClickListener {
                onClick.onClick(position,petList[position].image)
            }
        }
    }
}