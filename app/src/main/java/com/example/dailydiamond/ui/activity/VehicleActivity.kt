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
import com.example.dailydiamond.databinding.ActivityVehicleBinding
import com.example.dailydiamond.ui.adapter.CharactersAdapter
import com.example.dailydiamond.ui.model.Image

class VehicleActivity : BaseActivity() {

    private lateinit var binding: ActivityVehicleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVehicleBinding.inflate(layoutInflater)
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
        onBackPressedDispatcher.addCallback(this,object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                nativeClick()
                finish()
            }
        })
    }

    private fun initAdapter() {
        val vehicleList = ArrayList<Image>()
        vehicleList.add(Image(R.drawable.vehicle_1))
        vehicleList.add(Image(R.drawable.vehicle_2))
        vehicleList.add(Image(R.drawable.vehicle_3))
        vehicleList.add(Image(R.drawable.vehicle_4))
        vehicleList.add(Image(R.drawable.vehicle_5))
        vehicleList.add(Image(R.drawable.vehicle_6))
        vehicleList.add(Image(R.drawable.vehicle_7))
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CharactersAdapter(this,vehicleList,object : CharactersAdapter.OnClick{
            override fun onClick(position: Int, image: Int) {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@VehicleActivity,VehicleInfoActivity::class.java).apply {
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