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
import com.example.dailydiamond.databinding.ActivityCharacterInfoBinding
import com.example.dailydiamond.databinding.ActivityPetsInfoBinding
import com.example.dailydiamond.ui.model.Info

class BundlesInfoActivity : BaseActivity() {
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
        onBackPressedDispatcher.addCallback(this,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                nativeClick()
                finish()
            }
        })
        val info = ArrayList<Info>()
        info.add(Info(
            "Sakura",
            "Garena introduced the beautiful sakura Bundle Through the first season of Elite Pass and it rapidly become a famous character outfit after.")
        )
        info.add(Info(
            "Bunny Warrior",
            "Bunny Warrior is another eye-grabbing BATTLEGROUNDS character outfit that has been one of the most unique bundle.This outfit was a part of the drw a Bunny event that granted a Getturn to players daily to drw a bunnyon the mirror.")
        )
        info.add(Info(
            "Hip-Hop",
            "Hip Hop Bundle is one of the most popular and rarest bundle in BATTLEGROUNDS.It was a part of the Elite Pass in Season2 and Become an uncommon bundle after its first removal.")
        )
        info.add(Info(
            "Red Criminal",
            "Red Criminal Bundle top criminal fire criminal bundle BATTLEGROUNDS.The Criminal Bundle is one of the most beloved bundle of all time.")
        )
        info.add(Info(
            "King's Sward",
            "The King Sword bundle has been in the in-game store for quite a while now it was initally added in march 2019,and at the ,It could be obtained by spending diamonds.")
        )
        info.add(Info(
            "Green Criminal",
            "Green Criminial is arguably the rarest BATTLEGROUNDS Bundle as it was claimed by a small chuk of players when it was introduced in-game.Green Criminal is not available in the BATTLEGROUNDS Store.")
        )
        info.add(Info(
            "Night Clow",
            "The Night Clown Bundle is one of the most sought-after bundles in the game.it was initially available in November 2018 as a part of the diamonds royale.")
        )
        info.add(Info(
            "Breakdancer",
            "One of the ongoing Live events of BATTLEGROUNDS is the breakdancer bundle giveaway.The event is in collaboration with india content creators on YouTube.")
        )
        info.add(Info(
            "Samurai",
            "Zombifiend bundle in BATTLEGROUNDS.This bundle was released back in 2019 when the game had very less.")
        )

        val position = intent.getIntExtra("position",0)
        binding.txtTitle.text = info[position].title
        binding.txtInfo.text = info[position].info
        binding.imgMain.setImageResource(intent.getIntExtra("image",0))
        binding.btnClaim.setOnClickListener {
            showInter(object : OnAdCloseListener{
                override fun onClose() {
                    Intent(this@BundlesInfoActivity,IDActivity::class.java).apply {
                        putExtra("image",intent.getIntExtra("image",0))
                        startActivity(this)
                    }
                }
            })
        }
        binding.btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }
}