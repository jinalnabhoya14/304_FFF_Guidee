package com.example.dailydiamond.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dailydiamond.R
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.adBanner
import com.example.dailydiamond.ad.adSmall
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityDiamondCalcBinding

class DiamondCalcActivity : BaseActivity() {
    private lateinit var binding: ActivityDiamondCalcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiamondCalcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ad170.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }
        binding.ad40sdp.apply {
            let { adSmall(it) }
            setOnClickListener { nativeClick() }
        }
        binding.adBottom.apply {
            let { adBanner(it) }
            setOnClickListener { nativeClick() }
        }

        onBackPressedDispatcher.addCallback(this,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                nativeClick()
                finish()
            }
        })
        binding.apply {
            layout1.setOnClickListener {
                showInter(object : OnAdCloseListener {
                    override fun onClose() {
                        Intent(this@DiamondCalcActivity,DiamondCountActivity::class.java).apply {
                            putExtra("basic","basic")
                            startActivity(this)
                        }
                    }
                })
            }
            layout2.setOnClickListener {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@DiamondCalcActivity,DiamondCountActivity::class.java).apply {
                            putExtra("normal","normal")
                            startActivity(this)
                        }
                    }
                })
            }
            layout3.setOnClickListener {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@DiamondCalcActivity,DiamondCountActivity::class.java).apply {
                            putExtra("advance","advance")
                            startActivity(this)
                        }
                    }
                })
            }
            btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
        }
    }
}