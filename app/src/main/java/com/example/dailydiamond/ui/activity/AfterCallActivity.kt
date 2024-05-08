package com.example.dailydiamond.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import com.example.dailydiamond.R
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.callIntent
import com.example.dailydiamond.ad.getAfterCallInterStatus
import com.example.dailydiamond.ad.getAfterCallURL
import com.example.dailydiamond.ad.getAfterCallURLStatus
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityAfterCallBinding

class AfterCallActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAfterCallBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAfterCallBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.decorView.systemUiVisibility = 12290
        StutasbarColor()
        if (getAfterCallURLStatus()){
            openURL()
        }

        binding.adBottom.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }

        binding.layoutApp.setOnClickListener {
            if (getAfterCallInterStatus()) {
                showInter(object : OnAdCloseListener {
                    override fun onClose() {
                        startActivity(Intent(this@AfterCallActivity, MainActivity::class.java))
                    }
                })
            }else{startActivity(Intent(this@AfterCallActivity, MainActivity::class.java))}
        }
        binding.apply {
            calc.setOnClickListener {
                if (getAfterCallInterStatus()){
                    showInter(object :OnAdCloseListener{
                        override fun onClose() {
                            startActivity(Intent(this@AfterCallActivity,DiamondCalcActivity::class.java))
                        }
                    })
                }else{startActivity(Intent(this@AfterCallActivity,DiamondCalcActivity::class.java))}
            }
            character.setOnClickListener {
                if (getAfterCallInterStatus()) {
                    showInter(object : OnAdCloseListener {
                        override fun onClose() {
                            startActivity(Intent(this@AfterCallActivity, CharactersActivity::class.java))
                        }
                    })
                }
            }
            diamond.setOnClickListener {
                if (getAfterCallInterStatus()) {
                    showInter(object : OnAdCloseListener {
                        override fun onClose() {
                            startActivity(Intent(this@AfterCallActivity, DiamondActivity::class.java))
                        }
                    })
                }else{startActivity(Intent(this@AfterCallActivity, DiamondActivity::class.java))}
            }
        }
    }
    fun openURL() {
        val customIntent = CustomTabsIntent.Builder().build()
        customIntent.intent.data = Uri.parse(getAfterCallURL())
        callIntent(object : OnAdCloseListener{
            override fun onClose() {
            }
        },customIntent.intent)
    }
    private fun StutasbarColor() {
        val window = this.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = getResources().getColor(R.color.white)
    }
}