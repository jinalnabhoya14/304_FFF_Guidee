package com.example.dailydiamond.ui.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.dailydiamond.R
import com.example.dailydiamond.databinding.LayoutLanguageBinding
import com.example.dailydiamond.ui.model.Language
import com.example.dailydiamond.util.TinyDB

class LanguageAdapter(var activity:Activity,var list:ArrayList<Language>, var onClickLanguage: OnClickLanguage) : RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {

    interface OnClickLanguage {
        fun onClick(language: Language)
    }

    class ViewHolder(val binding:LayoutLanguageBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutLanguageBinding.inflate(LayoutInflater.from(activity),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            binding.apply {
                imgFlag.setImageResource(list[position].icon)
                txtLang.text = list[position].languageName
                btnRadio.isChecked = TinyDB(activity).getString("langCode", "en") == list[position].code
                if (btnRadio.isChecked){
                    cardLanguage.strokeColor = ContextCompat.getColor(activity,R.color.colorAccent)
                    cardLanguage.setCardBackgroundColor(ContextCompat.getColor(activity,R.color.colorAccentLight))
                }
                else {
                    cardLanguage.background = ContextCompat.getDrawable(activity, android.R.color.transparent)
                }
                root.setOnClickListener {
                    cardLanguage.strokeColor = ContextCompat.getColor(activity,R.color.colorAccent)
                    onClickLanguage.onClick(list[position])
                }
            }
        }
    }
}