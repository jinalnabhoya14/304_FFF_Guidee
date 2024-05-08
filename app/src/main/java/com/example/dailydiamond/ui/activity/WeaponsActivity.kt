package com.example.dailydiamond.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailydiamond.R
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.adBanner
import com.example.dailydiamond.ad.adSmall
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityWeaponsBinding
import com.example.dailydiamond.ui.adapter.CharactersAdapter
import com.example.dailydiamond.ui.model.Image

class WeaponsActivity : BaseActivity() {

    private lateinit var binding: ActivityWeaponsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeaponsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        binding.ad170.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }
        binding.ad40sdp.apply {
            let { adSmall(it) }
            setOnClickListener { nativeClick() }
        }
        binding.adBottomNative.apply {
            let { adBanner(it) }
            setOnClickListener { nativeClick() }
        }
        onBackPressedDispatcher.addCallback(this,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                nativeClick()
                finish()
            }
        })
    }
    private fun initAdapter() {

        val weaponList = ArrayList<Image>()
        weaponList.add(Image(R.drawable.weapon_1))
        weaponList.add(Image(R.drawable.weapon_2))
        weaponList.add(Image(R.drawable.weapon_3))
        weaponList.add(Image(R.drawable.weapon_4))
        weaponList.add(Image(R.drawable.weapon_5))
        weaponList.add(Image(R.drawable.weapon_6))
        weaponList.add(Image(R.drawable.weapon_7))
        weaponList.add(Image(R.drawable.weapon_8))
        weaponList.add(Image(R.drawable.weapon_9))

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CharactersAdapter(this,weaponList,object : CharactersAdapter.OnClick{
            override fun onClick(position: Int, image: Int) {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@WeaponsActivity,WeaponInfoActivity::class.java).apply {
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