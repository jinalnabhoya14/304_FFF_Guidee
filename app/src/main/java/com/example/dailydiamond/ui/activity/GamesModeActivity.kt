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
import com.example.dailydiamond.databinding.ActivityGamesModeBinding

class GamesModeActivity : BaseActivity() {
    private lateinit var binding: ActivityGamesModeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamesModeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ad170sdp.apply {
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
            btn1.setOnClickListener {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@GamesModeActivity,LevelActivity::class.java).apply {
                            putExtra("image",intent.getIntExtra("image",0))
                            putExtra("title",intent.getStringExtra("title"))
                            putExtra("gridLayout",intent.getStringExtra("gridLayout"))
                            startActivity(this)
                        }
                    }
                })
            }
            btn2.setOnClickListener {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@GamesModeActivity,LevelActivity::class.java).apply {
                            putExtra("image",intent.getIntExtra("image",0))
                            putExtra("title",intent.getStringExtra("title"))
                            putExtra("gridLayout",intent.getStringExtra("gridLayout"))
                            startActivity(this)
                        }
                    }
                })
            }
            btn3.setOnClickListener {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@GamesModeActivity,LevelActivity::class.java).apply {
                            putExtra("image",intent.getIntExtra("image",0))
                            putExtra("title",intent.getStringExtra("title"))
                            putExtra("gridLayout",intent.getStringExtra("gridLayout"))
                            startActivity(this)
                        }
                    }
                })
            }
            btn4.setOnClickListener {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@GamesModeActivity,LevelActivity::class.java).apply {
                            putExtra("image",intent.getIntExtra("image",0))
                            putExtra("title",intent.getStringExtra("title"))
                            putExtra("gridLayout",intent.getStringExtra("gridLayout"))
                            startActivity(this)
                        }
                    }
                })
            }
            btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
        }
    }
}