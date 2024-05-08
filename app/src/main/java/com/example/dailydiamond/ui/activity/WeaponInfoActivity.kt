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

class WeaponInfoActivity : BaseActivity() {
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
            "M14",
            "M14 has the highest damage and accuracy of all assault rifles, and is a deadly weapon in the hands of skilled players. In terms of range, it is only 1 point behind the M4A1, so it is useful at long distances. Indeed, its firing rhythm is the lowest in the list, but various accessories can be added to turn the weapon into a more powerful weapon.\n This is a weapon for experienced players. Compared with other weapons, its magazine is smaller.")
        )
        info.add(Info(
            "AN94",
            "This is the latest assault rifle from BATTLEGROUNDS. it behaves like a kind of M4A1, but in  addition to damage, the function is worse. If you choose mid-range combat, this is a good choice because you will be able to cause good damage. Remember that  you can add all other features except the silencer, so it is always a nosisy weapon in your hands.\n If you cannot find a more powerful assault rifle, please use AN94.")
        )
        info.add(Info(
            "Ak 47",
            "Not only in the game, but also in the battle royale and shooter world, AK is also another most famous weapon. These features really deserve a reputation, because it is one of the rifles with more damage and range. The downside is that it is the least accurate on the list, although fortunately, it can be solved with additional features.\n If you are patient with shooting two to three bullets, you can quickly destroy the enemy.")
        )
        info.add(Info(
            "MAG-7",
            "The MP5 has a steady fire rate and moderate accuracy in long-range engagements, but deals low damage per bullet in comparison to its sister, the UMP. It performs well in close-quarters, begin able to down a player quickly, given that they are unarmed or not attacking back.")
        )
        info.add(Info(
            "AUG",
            "The AUG is the latest arrival in the collection of weapons in Free Fire. It has pretty impressive stats, which makes it a viable option. The magazine size of the gun is 35.\n\nThis firearm is available in Classic Battle Royale and Clash Squad (both ranked and classic modes.) Here are the stats of the AUG, taken from the official website of the game:\nDAMAGE: 56\nRATE OF FIRE: 61\nRANGE: 56\nRELOAD SPEED: 48\nMAGAZINE: 35\nACCURACY: 35\nMOVEMENT SPEED: 50\nARMOR PENETRATION: 0\nThe AUG comes with a pre-equipped 2x Scope, but players can change and replace it with others. They can also equip all attachments on the gun, which makes it very versatile on the battlefield.")
        )
        info.add(Info(
            "M4A1",
            "M4A1 is one of the most famous weapons in the game and the most powerful assault rifle. Coupled with its good damage  and accuracy, it is not surprising that this weapon is the favorite of many players. In addition,  it is usually easy to find during the game, especially in military venues.\n Its biggest advantage is that we can add verious additional functions, which is perfect for novices and experienced players.")
        )
        info.add(Info(
            "GRoZA",
            "The combination of damage and shooting rhythm, as well as long range and good accuracy, make GROZA one of the best assault rifles. If it is already very good, then the fact that we can add various additional features will make your enemies feel terrified. The downside is that it can only be used in droplet form, that is, available in a supply box.\n Please pay attention to the box below, because if you see one of them equipped with GROZA weapons, please take it away immediately. You will not regret it!")
        )
        info.add(Info(
            "SCAR",
            "SCAR is not the most accurateweapon in the game. In fact, it is worse than AN94 in almost all functions. Its advantage is that the assault rifle can fire the most bullets per second, so it is very useful in close competitions. Fortunately, all possible accessories can be added to make up for these shortcomings.\n If you think you will spend more time in buildings or other enclosed spaces, then SCAR is a good choice.")
        )
        info.add(Info(
            "FAMAS",
            "FAMAS is one of the best assault rifles in this battle royale, but it is also the most difficult rifle to handle. waerksees lee MINCED SMU Rete KO mrs IRN ATL (ee so it is crucial to be targeted to avoid waste. Its long range, coupled with good damage and accuracy, make it the deadliest weapon in short Distances.\n We recommend FAMAS to people who are experienced and know how to deal with recoil from gusts.")
        )

        val position = intent.getIntExtra("position",0)
        binding.txtTitle.text = info[position].title
        binding.txtInfo.text = info[position].info
        binding.imgMain.setImageResource(intent.getIntExtra("image",0))
        binding.btnClaim.setOnClickListener {
            showInter(object : OnAdCloseListener{
                override fun onClose() {
                    Intent(this@WeaponInfoActivity,IDActivity::class.java).apply {
                        putExtra("image",intent.getIntExtra("image",0))
                        startActivity(this)
                    }
                }
            })
        }
        binding.btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }
}