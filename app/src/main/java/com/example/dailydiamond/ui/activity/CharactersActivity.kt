package com.example.dailydiamond.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailydiamond.R
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityCharactersBinding
import com.example.dailydiamond.ui.adapter.CharactersAdapter
import com.example.dailydiamond.ui.model.Image

class CharactersActivity : BaseActivity() {

    private lateinit var binding: ActivityCharactersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharactersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ad170.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }
        binding.adBottomNative.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }
        initAdapter()
        onBackPressedDispatcher.addCallback(this,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                nativeClick()
                finish()
            }
        })

    }

    private fun initAdapter() {

        val characterList = ArrayList<Image>()
        characterList.add(Image(R.drawable.character_1))
        characterList.add(Image(R.drawable.character_2))
        characterList.add(Image(R.drawable.character_3))
        characterList.add(Image(R.drawable.character_4))
        characterList.add(Image(R.drawable.character_5))
        characterList.add(Image(R.drawable.character_6))
        characterList.add(Image(R.drawable.character_7))
        characterList.add(Image(R.drawable.character_8))
        characterList.add(Image(R.drawable.character_9))
        characterList.add(Image(R.drawable.character_10))
        characterList.add(Image(R.drawable.character_11))
        characterList.add(Image(R.drawable.character_12))


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CharactersAdapter(this,characterList,object : CharactersAdapter.OnClick{
            override fun onClick(position: Int, image: Int) {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@CharactersActivity,CharacterInfoActivity::class.java).apply {
                            putExtra("position",position)
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