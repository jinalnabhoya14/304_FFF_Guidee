package com.example.dailydiamond.ui.activity

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.adBanner
import com.example.dailydiamond.ad.adSmall
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityDiamondCountBinding


class DiamondCountActivity : BaseActivity() {
    private lateinit var binding: ActivityDiamondCountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiamondCountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ad170sdp.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }
        binding.adBottom.apply {
            let { adBanner(it) }
            setOnClickListener { nativeClick() }
        }
        onBackPressedDispatcher.addCallback(this,object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                nativeClick()
                finish()
            }
        })
        binding.apply {
            btnClaim.setOnClickListener {
                if (etDollar.text?.isEmpty() == true){
                    etDollar.error = "Please Enter Number of Dollars"
                }else {
                    val string = etDollar.text
                    val num1: Int = Integer.parseInt(string.toString())

                    val basic = String.format("%.2f", *arrayOf<Any>(num1.toFloat() / 71.45).copyOf<Any>(1))
                    val normal = String.format("%.4f", *arrayOf<Any>(num1.toFloat() / 153.37f).copyOf<Any>(1))
                    val advance = String.format("%.2f", *arrayOf<Any>(num1.toFloat() / 62.5f).copyOf<Any>(1))

                    if (intent.getStringExtra("basic") == "basic") {
                        txtCount.text = (basic + " Dollars")
                    } else if (intent.getStringExtra("normal") == "normal") {
                        txtCount.text = (normal + " Dollars")
                    } else if (intent.getStringExtra("advance") == "advance") {
                        txtCount.text = (advance + " Dollars")
                    }
                }
            }
            btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
        }
    }
}