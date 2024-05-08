package com.example.dailydiamond.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dailydiamond.R
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityParachuteBinding
import com.example.dailydiamond.ui.adapter.PetsAdapter
import com.example.dailydiamond.ui.model.Image

class ParachuteActivity : BaseActivity() {
    private lateinit var binding: ActivityParachuteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParachuteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        binding.ad170.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }
        binding.adBottomNative.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }
        onBackPressedDispatcher.addCallback(this,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                nativeClick()
                finish()
            }
        })
    }

    private fun initAdapter() {
        val parachuteList = ArrayList<Image>()
        parachuteList.add(Image(R.drawable.parachute_1))
        parachuteList.add(Image(R.drawable.parachute_2))
        parachuteList.add(Image(R.drawable.parachute_3))
        parachuteList.add(Image(R.drawable.parachute_4))
        parachuteList.add(Image(R.drawable.parachute_5))
        parachuteList.add(Image(R.drawable.parachute_6))
        parachuteList.add(Image(R.drawable.parachute_7))
        parachuteList.add(Image(R.drawable.parachute_8))
        parachuteList.add(Image(R.drawable.parachute_9))
        parachuteList.add(Image(R.drawable.parachute_10))
        parachuteList.add(Image(R.drawable.parachute_11))
        parachuteList.add(Image(R.drawable.parachute_12))

        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(this@ParachuteActivity,2)
            recyclerView.adapter = PetsAdapter(this@ParachuteActivity,parachuteList,object : PetsAdapter.OnClick{
                override fun onClick(position: Int, image: Int) {
                    showInter(object : OnAdCloseListener{
                        override fun onClose() {
                            Intent(this@ParachuteActivity,ParachuteInfoActivity::class.java).apply {
                                putExtra("position",position)
                                putExtra("image",image)
                                startActivity(this)
                            }
                        }
                    })
                }
            })
            btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
        }
    }
}