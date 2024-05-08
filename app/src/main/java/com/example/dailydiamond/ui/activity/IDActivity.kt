package com.example.dailydiamond.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.OnBackPressedCallback
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.adSmall
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityIdactivityBinding


class IDActivity : BaseActivity() {
    private lateinit var binding: ActivityIdactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdactivityBinding.inflate(layoutInflater)
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
            btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
            btnClaim.setOnClickListener {
                if (etId.text?.isEmpty() == true){
                    etId.error = "Please Enter Id"
                }else{
                    showInter(object :OnAdCloseListener{
                        override fun onClose() {
                            Intent(this@IDActivity,GamesModeActivity::class.java).apply {
                                putExtra("image",intent.getIntExtra("image",0))
                                putExtra("tile",intent.getStringExtra("title"))
                                putExtra("gridLayout",intent.getStringExtra("gridLayout"))
                                startActivity(this)
                            }
                        }
                    })
                }
            }
            btnSkip.setOnClickListener {
                showInter(object :OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@IDActivity,GamesModeActivity::class.java).apply {
                            putExtra("image",intent.getIntExtra("image",0))
                            putExtra("tile",intent.getStringExtra("title"))
                            putExtra("gridLayout",intent.getStringExtra("gridLayout"))
                            startActivity(this)
                        }
                    }
                })
            }
        }
    }
}