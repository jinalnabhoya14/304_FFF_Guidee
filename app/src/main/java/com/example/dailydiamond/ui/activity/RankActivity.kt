package com.example.dailydiamond.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dailydiamond.R
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.adBanner
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityRankBinding
import com.example.dailydiamond.ui.adapter.PetsAdapter
import com.example.dailydiamond.ui.model.Image

class RankActivity : BaseActivity() {
    private lateinit var binding: ActivityRankBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRankBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ad170sdp.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }
        binding.adBottom.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }

        onBackPressedDispatcher.addCallback(this,object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                nativeClick()
                finish()
            }
        })
        val rankList = ArrayList<Image>()
        rankList.add(Image(R.drawable.img_rank_1))
        rankList.add(Image(R.drawable.img_rank_2))
        rankList.add(Image(R.drawable.img_rank_3))
        rankList.add(Image(R.drawable.img_rank_4))
        rankList.add(Image(R.drawable.img_rank_5))
        rankList.add(Image(R.drawable.img_rank_6))
        rankList.add(Image(R.drawable.img_rank_7))

        binding.apply {
            btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
            recyclerView.layoutManager = GridLayoutManager(this@RankActivity,2,RecyclerView.VERTICAL,false)
            recyclerView.adapter = PetsAdapter(this@RankActivity,rankList,object : PetsAdapter.OnClick{
                override fun onClick(position: Int, image: Int) {
                    showInter(object :OnAdCloseListener{
                        override fun onClose() {
                            Intent(this@RankActivity,EndActivity::class.java).apply {
                                putExtra("image",intent.getIntExtra("image",0))
                                startActivity(this)
                            }
                        }
                    })
                }
            })
        }
    }
}