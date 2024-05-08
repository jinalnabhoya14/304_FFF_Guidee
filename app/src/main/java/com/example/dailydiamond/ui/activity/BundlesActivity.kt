package com.example.dailydiamond.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailydiamond.R
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityBundlesBinding
import com.example.dailydiamond.ui.adapter.CharactersAdapter
import com.example.dailydiamond.ui.model.Image

class BundlesActivity : BaseActivity() {

    private lateinit var binding:ActivityBundlesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBundlesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ad170.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }
        binding.adBottomNative.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }
        onBackPressedDispatcher.addCallback(this,object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                nativeClick()
                finish()
            }
        })
        initAdapter()
    }

    private fun initAdapter() {
        val bundleList = ArrayList<Image>()
        bundleList.add(Image(R.drawable.bundle_1))
        bundleList.add(Image(R.drawable.bundle_2))
        bundleList.add(Image(R.drawable.bundle_3))
        bundleList.add(Image(R.drawable.bundle_4))
        bundleList.add(Image(R.drawable.bundle_5))
        bundleList.add(Image(R.drawable.bundle_6))
        bundleList.add(Image(R.drawable.bundle_7))
        bundleList.add(Image(R.drawable.bundle_8))
        bundleList.add(Image(R.drawable.bundle_9))
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CharactersAdapter(this,bundleList,object :CharactersAdapter.OnClick{
            override fun onClick(position: Int, image: Int) {
                showInter(object :OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@BundlesActivity,BundlesInfoActivity::class.java).apply {
                            putExtra("position",position)
                            putExtra("image",image)
                            startActivity(this)
                        }
                    }
                })
            }
        })
        binding.btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }
}