package com.example.dailydiamond.ui.activity.screen

import android.content.Intent
import android.os.Bundle
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityPrivacyScreenBinding
import com.example.dailydiamond.ui.activity.BaseActivity
import com.example.dailydiamond.util.TinyDB

class PrivacyScreenActivity : BaseActivity() {

    private var binding: ActivityPrivacyScreenBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrivacyScreenBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.apply {
            buttonAccept.setOnClickListener {
                showInter( object : OnAdCloseListener {
                    override fun onClose() {
                        finish()
                    }
                })
            }
        }
    }
}