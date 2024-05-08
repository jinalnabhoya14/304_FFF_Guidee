package com.example.dailydiamond.ui.activity

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dailydiamond.R
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.databinding.ActivityDiamondInfoBinding

class DiamondInfoActivity : BaseActivity() {
    private lateinit var binding: ActivityDiamondInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiamondInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ad170.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }
        binding.adBottomNative.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }
        onBackPressedDispatcher.addCallback(this,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                nativeClick()
                finish()
            }
        })
        binding.btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
        binding.txtTitle.text = intent.getStringExtra("title")
        binding.txtInfo.text = intent.getStringExtra("info")
    }
}