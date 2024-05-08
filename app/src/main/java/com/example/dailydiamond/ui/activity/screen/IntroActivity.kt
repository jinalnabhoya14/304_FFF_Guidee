package com.example.dailydiamond.ui.activity.screen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.dailydiamond.R
import com.example.dailydiamond.databinding.ActivityIntroBinding
import com.example.dailydiamond.ui.activity.BaseActivity
import com.example.dailydiamond.ui.adapter.IntroAdapter

class IntroActivity : BaseActivity() {

    private lateinit var binding: ActivityIntroBinding
    private var adapter : IntroAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initListener()
    }

    private fun initListener() {
        binding.apply {
            txtNext.setOnClickListener {
                val currentpos = viewPager.currentItem
                if (currentpos == 0) {
                    viewPager.currentItem = currentpos + 1
                }
                if (currentpos == 1) {
                    viewPager.currentItem = currentpos + 1
                }
                if (currentpos == 2) {
//                    showInterPart1(false,object : OnInterstitialListener {
//                        override fun onResult() {
                            startActivity(Intent(this@IntroActivity, StartActivity::class.java))
                            finish()
//                        }
//                    })
                }
            }
        }
    }

    private fun initView() {
        binding.apply {
            txtIntro.text = (getString(R.string.txt_intro_1))
            initAdapter()
            dotsIndicator.setViewPager2(binding.viewPager)

            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    viewPager.apply {
                        if (currentItem == 2) {
                            txtIntro.setText(R.string.txt_intro_3)
                            txtNext.setText(R.string.txt_start)
                        } else if (currentItem == 1) {
                            txtIntro.setText(R.string.txt_intro_2)
                            txtNext.setText(R.string.txt_next)
                        } else if (currentItem == 0) {
                            txtIntro.setText(R.string.txt_intro_1)
                            txtNext.setText(R.string.txt_next)
                        }
                    }
                }
            })
        }
    }

    private fun initAdapter() {
        adapter = IntroAdapter(this)
        binding.viewPager.adapter = adapter
    }

}