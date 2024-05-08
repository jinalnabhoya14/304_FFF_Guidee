package com.example.dailydiamond.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailydiamond.databinding.LayoutCharactersBinding
import com.example.dailydiamond.ui.model.Image

class CharactersAdapter(var activity: Activity, private var characterList:ArrayList<Image>, private var onClick: OnClick): RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    interface OnClick{
        fun onClick(position: Int,image:Int)
    }
    class ViewHolder(var binding: LayoutCharactersBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutCharactersBinding.inflate(LayoutInflater.from(activity),parent,false))
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            binding.imgCharacter.setImageResource(characterList[position].image)
            binding.imgCharacter.setOnClickListener {
                onClick.onClick(position,characterList[position].image)
            }
        }
    }
}