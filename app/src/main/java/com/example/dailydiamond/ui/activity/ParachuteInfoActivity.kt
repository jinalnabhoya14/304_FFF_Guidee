package com.example.dailydiamond.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.adBanner
import com.example.dailydiamond.ad.adSmall
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityPetsInfoBinding
import com.example.dailydiamond.ui.model.Info

class ParachuteInfoActivity : BaseActivity() {
    private lateinit var binding: ActivityPetsInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPetsInfoBinding.inflate(layoutInflater)
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
            "Apocalypse",
            "Apocalypse Parachute Details :\nAppearance: The Apocalypse Parachute features a dark and rugged design, with a black and gray color scheme and a skull and crossbones emblem.\nDurability: The Apocalypse Parachute has a durability of 100 points, which is higher than the standard parachute's durability.\nDeployment: The Apocalypse Parachute is deployed\nthe same way as the standard parachute, by tapping the \\\\\\\"jump\\\\\\\" button twice while in the air.\nSpeed: The Apocalypse Parachute has the same descent speed as the standard parachute, at 30 m/s.\nLanding: Players can control their landing by steering the Apocalypse Parachute towards a safe landing spot, just like with the standard parachute.\nCustomization: The Apocalypse Parachute cannot be further customized or upgraded, and its appearance cannot be changed.\nAdvantages: The Apocalypse Parachute provides a unique and intimidating appearance for players, which can help them stand out and intimidate enemies.\nDisadvantages: The Apocalypse Parachute does not provide any functional advantage over the standard parachute, and it can even attract more attention from enemies due to its distinctive appearance.")
        )
        info.add(Info(
            "Beach Party",
            "Beach Party Parachute Details :\nAppearance: The Beach Party Parachute features a colorful and festive design, with a bright pink and blue color scheme and beach-themed decorations, such as palm trees, beach balls, and umbrellas.\nDurability: The Beach Party Parachute has a durability of 100 points, which is higher than the standard parachute's durability.\nDeployment: The Beach Party Parachute is deployed the same way as the standard parachute, by tapping the \\\\\\\"jump\\\\\\\" button twice while in the air.\nSpeed: The Beach Party Parachute has the same descent speed as the standard parachute, at 30 m/s.\nLanding: Players can control their landing by steering the Beach Party Parachute towards a safe landing spot, just like with the standard parachute.\nCustomization: The Beach Party Parachute cannot be further customized or upgraded, and its appearance cannot be changed.\nAdvantages: The Beach Party Parachute provides a fun and playful appearance for players, which can help them stand out and lift the mood of the game.\nDisadvantages: The Beach Party Parachute does not provide any functional advantage over the standard parachute, and its bright colors and decorations can attract more attention from enemies.")
        )
        info.add(Info(
            "Panda",
            "Panda Parachute Details :\nAppearance: The Panda Parachute features a cute and adorable design, with a black and white color scheme and a panda face on the top of the parachute.\nDurability: The Panda Parachute has a durability of 100\npoints, which is higher than the standard parachute's durability.\nDeployment: The Panda Parachute is deployed the same way as the standard parachute, by tapping the jump\\\\\\\" button twice while in the air.\nSpeed: The Panda Parachute has the same descent speed as the standard parachute, at 30 m/s.\nLanding: Players can control their landing by steering the Panda Parachute towards a safe landing spot, just like with the standard parachute.\nCustomization: The Panda Parachute cannot be further customized or upgraded, and its appearance cannot be changed.\nAdvantages: The Panda Parachute provides a cute and charming appearance for players, which can help them stand out and attract positive attention from other players.\nDisadvantages: The Panda Parachute does not provide any functional advantage over the standard parachute, and its distinctive appearance can make players easier to spot by enemies.")
        )
        info.add(Info(
            "Cirsus",
            "Circus Parachute Details :\nAppearance: The Circus Parachute features a colorful and whimsical design, with a red and white striped pattern and circus-themed decorations, such as clowns, elephants, and circus tents.\nDurability: The Circus Parachute has a durability of 100 points, which is higher than the standard parachute's durability.\nDeployment: The Circus Parachute is deployed the same way as the standard parachute, by tapping the jump\\\\\\\" button twice while in the air.\nSpeed: The Circus Parachute has the same descent speed as the standard parachute, at 30 m/s.\nLanding: Players can control their landing by steering the Circus Parachute towards a safe landing spot, just like with the standard parachute.\nCustomization: The Circus Parachute cannot be further customized or upgraded, and its appearance cannot be changed.\nAdvantages: The Circus Parachute provides a fun and lighthearted appearance for players, which can help them stand out and add some humor to the game.\nDisadvantages: The Circus Parachute does not provide any functional advantage over the standard parachute,and its bright colors and decorations can attract more attention from enemies.")
        )
        info.add(Info(
            "Dragne",
            "Dragne Parachute Details :\nAppearance: The Dragne Parachute features a fearsome and epic design, with a red and black color scheme and dragon-themed decorations, such as dragon scales and wings.\nDurability: The Dragne Parachute has a durability of 100 points, which is higher than the standard parachute's durability.\nDeployment: The Dragne Parachute is deployed the same way as the standard parachute, by tapping the jump\\\\\\\" button twice while in the air.\nSpeed: The Dragne Parachute has the same descent speed as the standard parachute, at 30 m/s.\nLanding: Players can control their landing by steering the Dragne Parachute towards a safe landing spot, just like with the standard parachute.\nCustomization: The Dragne Parachute cannot be further customized or upgraded, and its appearance cannot be changed.\nAdvantages: The Dragne Parachute provides a menacing and powerful appearance for players, which can intimidate and impress other players.\nDisadvantages: The Dragne Parachute does not provide any functional advantage over the standard parachute, and its distinctive appearance can make players easier to spot by enemies.")
        )
        info.add(Info(
            "Dragon Slayor",
            "Dragon Slayer Parachute Details :\nAppearance: The Dragon Slayer Parachute features a fearsome and epic design, with a red and black color scheme and dragon-themed decorations, such as dragon scales and wings.\nDurability: The Dragon Slayer Parachute has a durability of 100 points, which is higher than the standard parachute's durability.\nDeployment: The Dragon Slayer Parachute is deployed the same way as the standard parachute, by tapping the \\\\\\\"jump\\\\\\\" button twice while in the air.\nSpeed: The Dragon Slayer Parachute has the same descent speed as the standard parachute, at 30 m/s.\nLanding: Players can control their landing by steering the Dragon Slayer Parachute towards a safe landing spot, just like with the standard parachute.\nCustomization: The Dragon Slayer Parachute cannot be further customized or upgraded, and its appearance cannot be changed.\nAdvantages: The Dragon Slayer Parachute provides a menacing and powerful appearance for players, which can intimidate and impress other players.\nDisadvantages: The Dragon Slayer Parachute does not provide any functional advantage over the standard parachute, and its distinctive appearance can make players easier to spot by enemies.\");\n")
        )
        info.add(Info(
            "Hip Hop",
            "Hip Hop Parachute Parachute Details :\nAppearance: The Hip Hop Parachute features a stylish and urban design, with a black and gold color scheme and graffiti-style lettering.\nDurability: The Hip Hop Parachute has a durability of 100 points, which is higher than the standard parachute's durability.\nDeployment: The Hip Hop Parachute is deployed the same way as the standard parachute, by tapping the jump\\\\\\\" button twice while in the air.\nSpeed: The Hip Hop Parachute has the same descent speed as the standard parachute, at 30 m/s.\nLanding: Players can control their landing by steering the Hip Hop Parachute towards a safe landing spot, just like with the standard parachute.\nCustomization: The Hip Hop Parachute cannot be further customized or upgraded, and its appearance cannot be changed.\nAdvantages: The Hip Hop Parachute provides a cool and trendy appearance for players, which can help them stand out and add some style to the game.\nDisadvantages: The Hip Hop Parachute does not provide any functional advantage over the standard parachute, and its bright colors and decorations can attract more attention from enemies.")
        )
        info.add(Info(
            "Cobra",
            "Cobra Parachute Parachute Details :\nAppearance: The Cobra Parachute features a colorful and whimsical design, with a red and white striped pattern and circus-themed decorations, such as clowns, elephants, and circus tents.\nDurability: The Cobra Parachute has a durability of 100 points, which is higher than the standard parachute's durability.\nDeployment: The Cobra Parachute is deployed the same way as the standard parachute, by tapping the jump\\\\\\\" button twice while in the air.\nSpeed: The Cobra Parachute has the same descent speed as the standard parachute, at 30 m/s.\nLanding: Players can control their landing by steering the Cobra Parachute towards a safe landing spot, just like with the standard parachute.\nCustomization: The Cobra Parachute cannot be further customized or upgraded, and its appearance cannot be changed.\nAdvantages: The Cobra Parachute provides a fun and lighthearted appearance for players, which can help them stand out and add some humor to the game.\nDisadvantages: The Cobra Parachute does not provide any functional advantage over the standard parachute, and its bright colors and decorations can attract more attention from enemies.")
        )
        info.add(Info(
            "Pantherea",
            "Panthera Parachute Parachute Details :\nAppearance: The Panthera Parachute features a black and yellow color scheme and a fierce panther design that covers the entire parachute.\nDurability: The Panthera Parachute has a durability of 100 points, which is higher than the standard parachute's durability.\nDeployment: The Panthera Parachute is deployed the same way as the standard parachute, by tapping the jump\\\\\\\" button twice while in the air.\nSpeed: The Panthera Parachute has the same descent speed as the standard parachute, at 30 m/s.\nLanding: Players can control their landing by steering the Panthera Parachute towards a safe landing spot, just like with the standard parachute.\nCustomization: The Panthera Parachute cannot be further customized or upgraded, and its appearance cannot be changed.\nAdvantages: The Panthera Parachute provides a fearsome and impressive appearance for players, which can intimidate and impress other players.\nDisadvantages: The Panthera Parachute does not provide any functional advantage over the standard parachute, and its distinctive appearance can make players easier to spot by enemies.")
        )
        info.add(Info(
            "Santa",
            "Santa Parachute Parachute Details :\nAppearance: The Santa Parachute features a red and white color scheme and a festive design with Santa Claus and snowflakes.\nDurability: The Santa Parachute has a durability of 100 points, which is higher than the standard parachute's durability.\nDeployment: The Santa Parachute is deployed the same way as the standard parachute, by tapping the jump\\\\\\\" button twice while in the air.\nSpeed: The Santa Parachute has the same descent speed as the standard parachute, at 30 m/s.\nLanding: Players can control their landing by steering the Santa Parachute towards a safe landing spot, just like with the standard parachute.\nCustomization: The Santa Parachute cannot be further customized or upgraded, and its appearance cannot be changed.\nAdvantages: The Santa Parachute provides a festive and cheerful appearance for players during the Christmas season, which can add some holiday spirit to the game.\nDisadvantages: The Santa Parachute does not provide any functional advantage over the standard parachute, and its distinctive appearance can make players easier to spot by enemies. Additionally, it is only available durina the Christmas season. which limits its usefulness throughout the rest of the year.")
        )
        info.add(Info(
            "Shark Attach",
            "Shark Attack Parachute Parachute Details :\nAppearance: The Shark Attack Parachute features a blue and white color scheme with a shark design that covers the entire parachute. The shark's jaws are open and appear to be attacking its prey.\nDurability: The Shark Attack Parachute has a durability of 100 points, which is the same as the standard parachute's durability.\nDeployment: The Shark Attack Parachute is deployed the same way as the standard parachute, by tapping the \\\\\\\"jump\\\\\\\" button twice while in the air.\nSpeed: The Shark Attack Parachute has the same descent speed as the standard parachute, at 30 m/s.\nLanding: Players can control their landing by steering the Shark Attack Parachute towards a safe landing spot, just like with the standard parachute.\nCustomization: The Shark Attack Parachute cannot be further customized or upgraded, and its appearance cannot be changed.\nAdvantages: The Shark Attack Parachute provides a unique and intimidating appearance for players, which can make them stand out and potentially intimidate other players.\nDisadvantages: The Shark Attack Parachute does not provide any functional advantage over the standard parachute, and its distinctive appearance can make players easier to spot by enemies.")
        )
        info.add(Info(
            "Winerlands",
            "Winerlands Parachute Parachute Details :\nAppearance: The Winerlands Parachute features a red and white color scheme and a festive design with Winerlands Claus and snowflakes.\nDurability: The Winerlands Parachute has a durability of 100 points, which is higher than the standard parachute's durability.\nDeployment: The Winerlands Parachute is deployed the same way as the standard parachute, by tapping the \\\\\\\"jump\\\\\\\" button twice while in the air.\nSpeed: The Winerlands Parachute has the same descent speed as the standard parachute, at 30 m/s.\nLanding: Players can control their landing by steering the Winerlands Parachute towards a safe landing spot, just like with the standard parachute.\nCustomization: The Winerlands Parachute cannot be further customized or upgraded, and its appearance cannot be changed.\nAdvantages: The Winerlands Parachute provides a festive and cheerful appearance for players during the Christmas season, which can add some holiday spirit to the game.\nDisadvantages: The Winerlands Parachute does not provide any functional advantage over the standard parachute, and its distinctive appearance can make players easier to spot by enemies. Additionally, it is only available during the Christmas season, which limits its usefulness throughout the rest of the year.")
        )
        val position = intent.getIntExtra("position",0)
        binding.txtTitle.text = info[position].title
        binding.txtInfo.text = info[position].info
        binding.imgMain.setImageResource(intent.getIntExtra("image",0))
        binding.btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
        binding.btnClaim.setOnClickListener {
            showInter(object : OnAdCloseListener{
                override fun onClose() {
                    Intent(this@ParachuteInfoActivity,IDActivity::class.java).apply {
                        putExtra("image",intent.getIntExtra("image",0))
                        startActivity(this)
                    }
                }
            })
        }
    }
}