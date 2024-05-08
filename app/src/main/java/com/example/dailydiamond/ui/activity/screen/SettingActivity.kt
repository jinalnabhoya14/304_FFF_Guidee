package com.example.dailydiamond.ui.activity.screen

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import com.example.dailydiamond.R
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivitySettingBinding
import com.example.dailydiamond.ui.activity.BaseActivity


class SettingActivity : BaseActivity() {
    private lateinit var binding: ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onBackPressedDispatcher.addCallback(this,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                nativeClick()
                finish()
            }
        })
        binding.apply {
            btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
            btnShare.setOnClickListener {
                val intent = Intent()
                intent.setAction("android.intent.action.SEND")
                intent.putExtra(
                    "android.intent.extra.TEXT", """${"Hey check out ${ContextCompat.getString(this@SettingActivity, R.string.app_name)}"} :
                            https://play.google.com/store/apps/details?id=$packageName"""
                )
                intent.setType("text/plain")
                try {
                    this@SettingActivity.startActivity(intent)
                } catch (unused: ActivityNotFoundException) {
                    Toast.makeText(this@SettingActivity, "Unable to open", 0).show()
                }
            }

            btnPrivacy.setOnClickListener {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        startActivity(Intent(this@SettingActivity,PrivacyScreenActivity::class.java))
                        finish()
                    }
                })
            }
        }

    }
}