package com.example.dailydiamond.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dailydiamond.R
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.adBanner
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityPetsBinding
import com.example.dailydiamond.ui.adapter.PetsAdapter
import com.example.dailydiamond.ui.model.Image

class PetsActivity : BaseActivity() {

    private lateinit var binding: ActivityPetsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPetsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        binding.ad170.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }
        binding.adBottomNative.apply {
            let { adBanner(it) }
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
        val petList = ArrayList<Image>()
        petList.add(Image(R.drawable.pets_1))
        petList.add(Image(R.drawable.pets_2))
        petList.add(Image(R.drawable.pets_3))
        petList.add(Image(R.drawable.pets_4))
        petList.add(Image(R.drawable.pets_5))
        petList.add(Image(R.drawable.pets_6))
        petList.add(Image(R.drawable.pets_7))
        petList.add(Image(R.drawable.pets_8))
        petList.add(Image(R.drawable.pets_9))
        petList.add(Image(R.drawable.pets_10))
        petList.add(Image(R.drawable.pets_11))
        petList.add(Image(R.drawable.pets_12))
        petList.add(Image(R.drawable.pets_13))
        petList.add(Image(R.drawable.pets_14))
        petList.add(Image(R.drawable.pets_15))
        petList.add(Image(R.drawable.pets_16))
        petList.add(Image(R.drawable.pets_17))
        petList.add(Image(R.drawable.pets_18))
        petList.add(Image(R.drawable.pets_19))
        petList.add(Image(R.drawable.pets_20))
        petList.add(Image(R.drawable.pets_21))

        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(this@PetsActivity,2,RecyclerView.VERTICAL,false)
            recyclerView.adapter = PetsAdapter(this@PetsActivity,petList,object : PetsAdapter.OnClick{
                override fun onClick(position: Int, image: Int) {
                    showInter(object :OnAdCloseListener{
                        override fun onClose() {
                            Intent(this@PetsActivity,PetsInfoActivity::class.java).apply {
                                putExtra("position",position)
                                putExtra("image",image)
                                startActivity(this)
                            }
                        }
                    })
                }
            })
            btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
        }
    }
}