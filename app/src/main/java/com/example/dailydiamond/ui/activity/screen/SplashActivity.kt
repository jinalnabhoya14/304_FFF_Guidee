package com.example.dailydiamond.ui.activity.screen

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dailydiamond.R
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.OnInit
import com.example.dailydiamond.ad.initSplash
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivitySplashBinding
import com.example.dailydiamond.ui.activity.BaseActivity
import com.example.dailydiamond.ui.activity.MainActivity

class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            statusBarColor = Color.TRANSPARENT
        }

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        initSplash(object :OnInit{
            override fun onInitComplete() {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@SplashActivity,MainActivity::class.java).apply {
                            startActivity(this)
                            finish()
                        }
                    }
                })
            }

            override fun onFail() {
                internetDialog()
            }
        },"304_FFF_Guide")
    }
}