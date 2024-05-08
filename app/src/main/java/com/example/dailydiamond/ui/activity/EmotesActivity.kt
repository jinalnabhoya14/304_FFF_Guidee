package com.example.dailydiamond.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dailydiamond.R
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityEmotesBinding
import com.example.dailydiamond.ui.adapter.PetsAdapter
import com.example.dailydiamond.ui.model.Image

class EmotesActivity : BaseActivity() {
    private lateinit var binding: ActivityEmotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        binding.adBottomNative.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }
        onBackPressedDispatcher.addCallback(this,object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                nativeClick()
                finish()
            }
        })
    }

    private fun initAdapter() {
        val emoteList = ArrayList<Image>()
        emoteList.add(Image(R.drawable.emotes_1))
        emoteList.add(Image(R.drawable.emotes_2))
        emoteList.add(Image(R.drawable.emotes_3))
        emoteList.add(Image(R.drawable.emotes_4))
        emoteList.add(Image(R.drawable.emotes_5))
        emoteList.add(Image(R.drawable.emotes_6))
        emoteList.add(Image(R.drawable.emotes_7))
        emoteList.add(Image(R.drawable.emotes_8))
        emoteList.add(Image(R.drawable.emotes_9))
        emoteList.add(Image(R.drawable.emotes_10))
        emoteList.add(Image(R.drawable.emotes_11))
        emoteList.add(Image(R.drawable.emotes_12))
        emoteList.add(Image(R.drawable.emotes_13))
        emoteList.add(Image(R.drawable.emotes_14))
        emoteList.add(Image(R.drawable.emotes_15))
        emoteList.add(Image(R.drawable.emotes_16))
        emoteList.add(Image(R.drawable.emotes_17))
        emoteList.add(Image(R.drawable.emotes_18))
        emoteList.add(Image(R.drawable.emotes_19))
        emoteList.add(Image(R.drawable.emotes_20))
        emoteList.add(Image(R.drawable.emotes_21))
        emoteList.add(Image(R.drawable.emotes_22))
        emoteList.add(Image(R.drawable.emotes_23))
        emoteList.add(Image(R.drawable.emotes_24))
        emoteList.add(Image(R.drawable.emotes_25))
        emoteList.add(Image(R.drawable.emotes_26))
        emoteList.add(Image(R.drawable.emotes_27))
        emoteList.add(Image(R.drawable.emotes_28))
        emoteList.add(Image(R.drawable.emotes_29))
        emoteList.add(Image(R.drawable.emotes_30))
        emoteList.add(Image(R.drawable.emotes_31))
        emoteList.add(Image(R.drawable.emotes_32))
        emoteList.add(Image(R.drawable.emotes_33))
        emoteList.add(Image(R.drawable.emotes_34))
        emoteList.add(Image(R.drawable.emotes_35))
        emoteList.add(Image(R.drawable.emotes_36))
        emoteList.add(Image(R.drawable.emotes_37))
        emoteList.add(Image(R.drawable.emotes_38))
        emoteList.add(Image(R.drawable.emotes_39))
        emoteList.add(Image(R.drawable.emotes_40))
        emoteList.add(Image(R.drawable.emotes_41))
        emoteList.add(Image(R.drawable.emotes_42))
        emoteList.add(Image(R.drawable.emotes_43))
        emoteList.add(Image(R.drawable.emotes_44))
        emoteList.add(Image(R.drawable.emotes_45))
        emoteList.add(Image(R.drawable.emotes_46))
        emoteList.add(Image(R.drawable.emotes_47))
        emoteList.add(Image(R.drawable.emotes_48))
        emoteList.add(Image(R.drawable.emotes_49))
        emoteList.add(Image(R.drawable.emotes_50))
        emoteList.add(Image(R.drawable.emotes_51))
        emoteList.add(Image(R.drawable.emotes_52))
        emoteList.add(Image(R.drawable.emotes_53))
        emoteList.add(Image(R.drawable.emotes_54))
        emoteList.add(Image(R.drawable.emotes_55))
        emoteList.add(Image(R.drawable.emotes_56))
        emoteList.add(Image(R.drawable.emotes_57))

        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(this@EmotesActivity,2)
            recyclerView.adapter = PetsAdapter(this@EmotesActivity,emoteList,object : PetsAdapter.OnClick{
                override fun onClick(position: Int, image: Int) {
                    showInter(object : OnAdCloseListener{
                        override fun onClose() {
                            Intent(this@EmotesActivity,EmotesInfoActivity::class.java).apply {
                                putExtra("image",image)
                                startActivity(this)
                            }
                        }
                    })
                }
            })
            binding.btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
        }
    }
}