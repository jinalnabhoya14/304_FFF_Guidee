package com.example.dailydiamond.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dailydiamond.R
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.adBanner
import com.example.dailydiamond.ad.adSmall
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityBunlesInfoBinding
import com.example.dailydiamond.ui.model.Info

class VehicleInfoActivity : BaseActivity() {
    private lateinit var binding: ActivityBunlesInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBunlesInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ad170.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }
        binding.ad40sdp.apply {
            let { adSmall(it) }
            setOnClickListener { nativeClick() }
        }
        binding.adBanner.apply {
            let { adBanner(it) }
            setOnClickListener { nativeClick() }
        }
        onBackPressedDispatcher.addCallback(this,object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                nativeClick()
                finish()
            }
        })
        val info = ArrayList<Info>()
        info.add(Info(
            "Motor Cycle",
            "FFire's advance test server for the OB21 update has been officially out by Garena, and the developers are now preparing themselves to launch the update globally.  Before the update hits the store, a new two-seater vehicle has been spotted in the Advance test server, and the gameplay video has also been surfaced online. In the past, many players were requesting for the new vehicle in the game and prioritizing their feedbacks; the developers have finally initiated it.  \n \nThe good news is that since the motorcycle is small, you can move faster and pass through narrow places without many problems.")
        )
        info.add(Info(
            "Ambhiblan",
            "Amphibious vehicles are unique as they can be used on land and in water, which makes them highly coveted in the game. However, with a capacity of two and a top speed of 100 km/hr, it is the wrong choice when running away from the danger zone. \n \nAs you might expect, it is often found in areas with rivers nearby. If you want to explore on small islands or similar places, don’t worry, because you can return to the main terrain without being exposed by the connecting bridge. Many people are smart, waiting on the other side of the bridge! \n \nIn addition, since there is room for two people, the best vehicle can move freely in two-person mode!")
        )
        info.add(Info(
            "Monster Car",
            "The FFire Squad Beatz event has included an array of activities that have completely immersed players in the game. The event began a week ago, and the developers have even more activities lined up for players in the coming days.  The Weekend Party is a sub-event that will go live in a few days. Gamers are required to achieve a certain number of kills to earn rewards such as a monster truck skin. Here is a detailed guide for this event.")
        )
        info.add(Info(
            "Tuk Tuk",
            "Tuk Tuk is a slow vehicle, weak and abundant in the area. Dont use it unless you want to move quickly in the same village. Because it is a bit narrow, you can shuttle between houses, so even if it sounds ridiculous, it is useful in chasing. \n \nIn addition to having unique characters with different skills, FFire also has other unique features that are fun to watch, namely vehicles. In the FFire game there are lots of vehicles that can be used ranging from Jeeps, Trucks, Sports Cars, Motorcycles, Go-karts, Pick Ups and the most unique is Tuk-Tuk.")
        )
        info.add(Info(
            "Military Jeep",
            "This military jeep is one of the most versatile vehicles on the FFire map, but it is not very fast. If you are driving on a steep hill, you will notice that it is difficult for the jeep to overcome the slope, in fact, it is common for you to end up downhill. \n \nIf there are no other options, please drive this vehicle. Jeep can indeed withstand a lot of shooting, especially when you turn your back to the shooter. The rear part of the jeep can Getyou from multiple difficulties!")
        )
        info.add(Info(
            "Van",
            "The VAN is another vehicle that is very abundant on the map. It has a certain resistance, moderate speed, and provides good protection for the driver. If you dont need to return to a safe area immediately, this is a good choice to get from one town to another.")
        )
        info.add(Info(
            "Sport Car",
            "The sports car is the best vehicle in the game, as it has a top speed of 136 km/hr and a capacity of two people. This vehicle is also very durable and can be used to travel faster and safely during matches. \n \n Once you find a car, do not hesitate to drive one of them, especially if you leave the safe zone. If you find this car, you know that you will easily explore the map in just a minute. \n \n Curious details: Since the sports car is very fast, if you hit a pedestrian, he will fly away and take extra damage from the fall.")
        )

        val position = intent.getIntExtra("position",0)
        binding.txtTitle.text = info[position].title
        binding.txtInfo.text = info[position].info
        binding.imgMain.setImageResource(intent.getIntExtra("image",0))
        binding.btnClaim.setOnClickListener {
            showInter(object : OnAdCloseListener{
                override fun onClose() {
                    Intent(this@VehicleInfoActivity,IDActivity::class.java).apply {
                        putExtra("image",intent.getIntExtra("image",0))
                        startActivity(this)
                    }
                }
            })
        }
        binding.btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }
}