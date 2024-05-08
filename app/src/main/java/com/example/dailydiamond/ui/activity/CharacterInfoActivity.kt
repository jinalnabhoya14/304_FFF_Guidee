package com.example.dailydiamond.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.adSmall
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityCharacterInfoBinding
import com.example.dailydiamond.ui.model.Info

class CharacterInfoActivity : BaseActivity() {
    private lateinit var binding: ActivityCharacterInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniView()

        binding.ad170.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }
        binding.ad40sdp.apply {
            let { adSmall(it) }
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
                "A-Patroa",
                "A-Patroa character extra special skill slot can be equipped with any skill on the account and is automatically unlocked upon getting the character\n\nA-PATROA CHARACTERS INFORMATION :\n\nThe Ross (Anitta) is a strona and confident woman who has a music store and sensory experiences in a dangerous neighborhood. In addition, your store serves as a safe space for anyone seeking help. The experiences offered by the store are not only a form of fun, but also a way to help people. Patroa owns a music store that serves not only as a space for socializing and entertainment in a particularly dangerous region, but also as a shelter for people in vulnerable situations,\nespecially women. Space allows these women to explore and\nexperience freedom and security, free from judgment.\nIn the store it is possible to enjoy an experience technologically\ncreated by her that allows them to fully immerse themselves in\nemotions, memories and experiences. The experience is called\nRIO, as is the store.")
        )
        info.add(Info(
                "Dimitri",
                "Dimitri is the elder brother of Thiva. In his daily life, he would spend most of his day at the lab developing new sound technology. After he found his passion for music, he realized that helping the world and improving people's lives moving forward through his technological creations might be one of his dreams.\nDIMITRI CHARACTERS INFORMATION :\nDimitri is one of the recommended characters for players who prefer healing skills. He has an active skill called Healing Heartbeat. The skill allows its users to create 3.5m healing zones. Players who are inside the zone can recover 3HP/sec. If a player or teammate is down, they can self recover to get up. At its initial level, the skill lasts for 20 seconds and has a 85-second cooldown.\nPlayers can upgrade their character level by using EXP cards and playing more ranked matches. It will help them to unlock further upgrade levels of the character with improved skills.\nLevel 2: Duration increases by 11 seconds and cooldown reduces to 80 seconds.\nLevel 3: Duration increases by 12 seconds and the cooldown reduces to 75 seconds.\nLevel 4: Duration increases by 13 seconds and the cooldown reduces to 70 seconds.\nLevel 5: Duration increases by 14 seconds and the cooldown reduces to 65 seconds.\nLevel 6: Duration increases by 15 seconds and the cooldown reduces to 60 seconds.")
        )
        info.add(Info(
            "Otho",
            "Otho is not a collaboration character or classic\ncharacter. It is a character that has been added to\ncomics, which is the FF E-comics recently. This\ncharacter is a memory tech engineer from Polytech\nUniversity.\nOTHO CHARACTERS INFORMATION :\nOtho is not yet available in the in-game store. He is currently\navailable to players only if they make a purchase during the\nongoing top-up event. In this event players need to top-up\ncertain amount of diamonds to get Otho for free and if players\nwant they can also get the Otho character bundle.\nOtho'’s ability includes Memory Mist. When users eliminate\nenemies, Otho can reveal the locations of other foes within a\n25-meter radius. He can then share this information with the\nother teammates. As the player advances, the range to which\nOtho can use his ability also increases. The maximum potential\nfor the character is 50 meters.")
        )
        info.add(Info(
            "Thiva",
                "Thiva character At its initial level, the rescue speed\nis increased by 10%, and on successful rescue, the\nplayer recovers 15 HP in 5 seconds. The rescue\nspeed increases by 25%, and after rescuing the player\nrecovers 40 HP in 5 seconds, at its max level.\nTHIVA CHARACTERS INFORMATION :\nThiva is the little brother of Dimitri.\nHe was innately talented and played music throughout his\nchildhood.\nHe really wants to help the world and improve people's lives but\nbelieves the best way to do that is to reach the individual with a\ntrue message through his music.\nHis ability is called Vital Vibes, improving the help-up speed\nby 5% at the first level. Additionally, players who revived will\nreceive 15 health points in the next five seconds. The ability\nconsiderably improves as the level rises.\nAt the maximum level of 6, users’ help-up speed will be buffed\nto 20%, while the HP recovered after rescue stands at 40.")
        )
        info.add(Info(
            "Leon",
                "Leon is a university student and comes with extreme\nbasketball skills. The character comes with Buzzer\nBeater survival ability that allows players to recover HP\nafter engagement in combat.\nLEON CHARACTERS INFORMATION :\nWith Leon's ability being a passive skill, you can combine it with\npretty much all skills in the game, from long to close range. It is\nvery effective against chip damage - a combination of Buzzer\nBeater and EP could get you to full pretty quickly. Overall,\nAssaulter and Sniper builds are the best for Leon, as you can\nget 100 -> O rather quick in close range fights.\nLeon is another character that has been added to FF, and has\na unique ability named Buzzer Beater. He recovers HP after\nsurviving a combat encounter, and this can turn out to be\nhelpful during aggressive gameplay.\nThe exact details about the HP recovered at every level have\nbeen provided below:\nLevel 1\nHP recovery:5\nLevel 2\nHP recovery: 10\nLevel 3\nHP recovery: 15\nLevel 4\nHP recovery: 20\nLevel 5\nHP recovery: 25\nLevel 6\nHP recovery: 30\"")
        )
        info.add(Info(
            "Iris",
                "The Iris character in the game is an expert at Walls\nof Ice and has a powerful capacity to brand and\nexterminate foes on the battlefield, so your enemies\nmust be terrified.\nThe Iris character in the game is an expert at Walls\nof Ice and has a powerful capacity to brand and\nexterminate foes on the battlefield, so your enemies\nmust be terrified.\nLUNA CHARACTERS INFORMATION :\n\nIris has two crucial skill aspects, namely the ability to mark\nenemies and penetrate the Gloo Wall.\n\nOnce the skill is active, players only need to shoot the Gloo Wall\nto activate the enemy marker located behind the Gloo Wall.\nThe skill of Iris is able to attack the marked enemy behind the\nGloo Wall.\n\nIris\\\\\\\" skill can penetrate 5 Gloo Walls even in a parallel position.\nSo even enemies behind 5 Gloo Walls can still be attacked by\nIris.\n\nAt the maximum level, the cooldown of the skill is only 55\nseconds. Can even beat Skyler and Chrono.")
        )
        info.add(Info(
            "J.Biebs",
                "J.Biebs has a special survival skill called Night Silence,\nhelping players to overcome their opponents on\nthe battlefield. At its lowest level, Silence of Night\nallows users and their allies within 6 meters to block\nincoming damage using their EP.\nJ.BIEBS CHARACTERS INFORMATION :\nJ.Biebs is a man who wants to unite a fractured world. Through\nhis childhood experiences, he learned that the answer to\npeople’s problems is not money or power, but the actual\nconnection between people. He then decided to use his singing\nskills to dedicate his life to reunite the world. Silent Sentinel\nallows users and their allies to block damage using EP, and the\namount of EP deducted from allies will be added to the user’s\nEP. The range of this ability is 6 meters at the lowest level, while\nthe damage percentage prevented is 7%.")
        )
        info.add(Info(
            "Homer",
                "Homer possesses the unique ability named 'Senses\nShockwave. ' Upon activation of the skill on the\nbattlefield, it releases a drone towards the nearest\nenemy within a 100m frontal distance, creating\na 5m-diameter pulse explosion which reduces\nmovement speed by 10% and firing rate by 10%.\nHOMER CHARACTERS INFORMATION :\nHomer is a blind man who is also an assassin. He is the founder\nof Griza gang. The character comes with a special survival\nability, known as Sense Shockwave. With this, Homer is able\nto release a drone to the nearest frontal enemy, creating a\n5m-diameter pulse explosion, which reduces enemy movement\nspeed and firing speed.\nHe can release the drone at the closest frontal enemy, creating\na 5 meter diameter pulse burst that reduces the enemy's\nmovement speed and firing speed and deals 25 damage to\nthem. The duration of the slow effect is 5 seconds. The drone's\nsearch area is 100 meters in front, which is quite large.\nHomer's ability in FF is an active skill and can only be used for\ncombos with other passive skills. Overall, since the duration\nof the drone effect is quite short (5 seconds), it is the most\neffective in rusher combos.")
        )
        info.add(Info(
            "Luna",
                "Luna's Fight-or-Flight ability is of great use to players\nwho use weapons with slower fire rates. With a quicker\nfire rate, players can empty their magazine much\nfaster and deal more damage to their enemies. The\ncharacter's ability helps players enhance the weapon\nfire rate and increase movement speed, which helps in\nswift movement and better aim tracing in FF MAX.Luna's Fight-or-Flight ability is of great use to players\nwho use weapons with slower fire rates. With a quicker\nfire rate, players can empty their magazine much\nfaster and deal more damage to their enemies. The\ncharacter's ability helps players enhance the weapon\nfire rate and increase movement speed, which helps in\nswift movement and better aim tracing in FF MAX.\nLUNA CHARACTERS INFORMATION :\n\nLuna comes under the passive character list and is not bound\nby any time duration. The character is inspired by the popular\nThai actress “Yaya Urassaya.” Luna features a special passive\nability called Fight-or-Flight. With the help of this ability, players\ncan improve the firing rate of the weapon, and the movement\nspeed also increases.\n\nPlayers can use the character to use weapons that have great\ndamage per hit but lack a rate of fire. The character is suitable\nfor assault rifles and shotguns with heavy damage, and with\nLuna, the rate of fire will be enhanced. The character will be\navailable in the character store after the in-game event ends.")
        )
        info.add(Info(
            "Tatsuya",
                "Tatsuya is known for his speed as he is the fastest\namong the playable characters in the game. He is\nequipped with an active ability known as 'Rebel Rush'.\nThis special survival ability helps him move forward\nwith rapid speed. Also, this skill can be accumulated\nfor consecutive use.\nTATSUYA CHARACTERS INFORMATION :\nTatsuya'’s ability is active. So players will get to use the ability\nfor a limited duration only and it requires manual activation. He\ncan move forward at a rapid speed for a limited duration. This\nability will be a game changer when players will need to retreat\nfrom an intense fight.\nTatsuya can move forward at a rapid speed for 0.5 seconds.\nThe skill can be accumulated for consecutive uses (Up to\n2 times). It has a cool-down time as it is an active skill. The\nCooldown is 40 seconds. Moreover, if anyone uses the skill\nconsecutively, they will face an additional 5 seconds of cool\ndown between uses. Players can upgrade Tatsuya's skill by\nusing memory fragments which will eventually lower the\ncooldown to 30 seconds.")
        )
        info.add(Info(
            "Kenta",
            "Kenta character can create a front shield that can\nwithstand all enemy attacks from the front. He can\nnow protect his teammates.\nKENTA CHARACTERS INFORMATION :\nKenta does not have a unique ability, but can be equipped\nwith an existing ability. Kenta is a recommended character for\nbeginners, they can equip and experiment.\nUse against explosives: Kenta's ability proves very effective\nagainst grenades, launchers, and others. Using his shield power,\nplayers can tackle any combat including any explosives.\nPurely defensive: The area of the force field is quite large,\nso it protects teammates very effectively. The time to use\nSwordsman’s Wrath is also quite long. However, it automatically\ndisappears when Kenta takes any shot.\nNo one can attack through a force field: Swordsman’s Wrath\nblocks about half of enemy Weapons damage. That renders\nnearly every attack ineffective.")
        )
        info.add(
            Info(
            "Nairi",
                "Nairi's Ice Iron ability automatically heals the gloo\nwalls after they have been deployed. At level 1 of the\nability, the gloo walls recover 20% of their durability\nevery 20 seconds.\nNAIRI CHARACTERS INFORMATION :\nIn FF, Nairi's ability gets activated automatically. He has a\nspecial survival ability that the deployed Gloo walls will recover\na certain amount of current durability every 1 sec when damage\nis taken. Also, the user equipping this skill will get increased\ndamage on Gloo walls while shooting from any AR Weapons.")
        )

        val image = intent.getIntExtra("image",0)
        val position = intent.getIntExtra("position",0)
        binding.txtTitle.text = info[position].title
        binding.txtInfo.text = info[position].info
        binding.imgMain.setImageResource(image)

        binding.btnClaim.setOnClickListener {
            showInter(object : OnAdCloseListener{
                override fun onClose() {
                    Intent(this@CharacterInfoActivity,IDActivity::class.java).apply {
                        putExtra("title",info[position].title)
                        putExtra("image",image)
                        startActivity(this)
                    }
                }
            })
        }

        binding.btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun iniView() {

    }
}