package com.example.dailydiamond.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dailydiamond.R
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityEndBinding
import com.example.dailydiamond.ui.activity.screen.StartActivity

class EndActivity : BaseActivity() {
    private lateinit var binding: ActivityEndBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEndBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ad170sdp.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }

        onBackPressedDispatcher.addCallback(this,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                nativeClick()
                finish()
            }
        })

        binding.apply {
            imgMain.setImageResource(intent.getIntExtra("image",0))

            btnApply.setOnClickListener {
                cardFinal.visibility = View.VISIBLE
            }

            btnOk.setOnClickListener {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        startActivity(Intent(this@EndActivity,MainActivity::class.java))
                        finish()
                    }
                })
            }
            btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
        }
    }
}