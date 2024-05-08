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
import com.example.dailydiamond.databinding.ActivityPetsInfoBinding
import com.example.dailydiamond.ui.model.Info

class PetsInfoActivity : BaseActivity() {
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

        onBackPressedDispatcher.addCallback(this,object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                nativeClick()
                finish()
            }
        })

        val info = ArrayList<Info>()
        info.add(Info(
            "Agent Hop",
            "The Agent Hop pet's ability is to give the character EP health each time the Safe Zone shrinks , that is, a certain amount of EP health is given to the character each time the Safe decreases.Life EP in Free Fire means Energy Points , is that yellow bar that has the function of replacing the HP life (white) as it is consumed. It is possible to get EP life using mushrooms or inhalers for example.")
        )
        info.add(Info(
            "Beaston",
            "Beaston has an ability named 'Helping Hand'. This ability allows the users to throw their utilities at a longer range than usual. The throwables include hand grenades, smoke grenades, gloo walls, and flashbangs.")
        )
        info.add(Info(
            "Detective Panda",
            "The Detective Panda is one of the cutest pets available in the FF game. Its unique skill Panda’s Blessing restores 4 HP upon killing a foe. This HP restoration increases to 7 when the pet reaches Level 5.\nDETECTIVE PANDA Pet Information :\nDetective Panda is a pet that can be obtained only through events or direct purchase through the store. Its ability is called {Panda’s Blessings} which provides {4|7|10} HP per kill. Detective Panda's ability helps in healing and can be paired with almost every character. For example, players can pair it with Shani in the Clash Squad mode, where Panda restores HP for each kill and Shani restores armor durability. Panda can also be paired with Hayato or Maro, where it complements their abilities, armor-penetrating and increased damage over distance, by providing an extra healing advantage.")
        )
        info.add(Info(
            "Dr.Beanie",
            "The pet significantly increases the movement speed of the players when they are in the crouch position. The initial buff is 30%, which gradually increases and becomes 60% at the maximum level.")
        )
        info.add(Info(
            "Dreki",
            "Dreki is a cute mini dragon with big twinkle eyes, two small wings, short arms & legs, and a burning tail. Just like all other pets, Dreki also comes with three actions which are as follows: Celebrate, Play, and Show.\nDreki Pet Information :\nCelebration: This pet will perform this action when it is happy. When you defeat an enemy or use medkit, this pet also performs Celebration action.\nPlay: This action is unlocked when you upgrade this pet. You can use this action in the command wheel. The Show is an advanced action that can be used in the command wheel.The maximum level of this pet is level 7. You have to feed Dreki to level up it. There are two beautiful skins for Dreki, including Splashy Dreki and Default skin. With Splashy Dreki skin, your pet will look more unique and attractive. Moreover, you need to upgrade this pet and pay diamonds to get this unique skin for Dreki. After unlocking this pet, you need to name this pet.")
        )
        info.add(Info(
            "Moony",
            "The newest addition, ‘Moony’ is an alien pet. Even though Moony is not from this world, but he loves everything about us. Similar to other pets of the game, Moony also comes with a special ability. Moony pet’s special skill is named ‘Paranormal Protection.\nMOONY Pet Information :\nMoony has two pet actions that one can get for free by leveling it up. The two pet actions are: Celebrate and Play. It has a skin that players can get by leveling the pet up. The skin name is Hipster Moony. It can be unlocked at pet level 6. Speaking of its skill, at level one, it reduces 20% damage when the player is in an interaction countdown i.e. applying medkit or using a repair kit. At its max level, which is, skill level 3 (and pet level 7), the damage reduction gets raised to 35% during any interaction cooldown.")
        )
        info.add(Info(
            "Mr.Wanggor",
            "Mr. Waggor is a pet that can be obtained only through events or direct purchase through the store. Its ability is called {Smooth Gloo} which provides the player with {11112} Gloo wall every {120]100|80} seconds if no Gloo wall is in the inventory.\nMR. WAGGOR Pet Information :\nMr Waggor is the latest addition to the list of pets in FF and has an ability called 'Smooth Gloo'. When a player has less than 1/1/2 Gloo Wall grenades, Mr Waggor can produce 1 Gloo Wall grenade every 120/100/100 seconds. This ability will come handy in the final zone when the players run out of Gloo Wall grenades. This item comes in handy for players who want to reposition to get the upper hand against their enemies. Produces a Gloo Wall grenade when the owner seems to be needing one. When player has no Gloo Wall grenade, Mr.Waggor can produce Gloo Wall grenade every 120 seconds.")
        )
        info.add(Info(
            "Night Panther",
            "The Panther Night possesses an ability called Weight Training. This ability will increase the player's inventory space by 15 at its default level (Level 1). The player's inventory space increases up to 45 when Night panther is maximized to pet level 7and skill level 3.")
        )
        info.add(Info(
            "Ottero",
            "The ability of Ottero Pet In FF is pretty unique because whenever you increase your HP, this pet will automatically increase your EP by using the Treatment Weapons or the Med Kit. Therefore this set stays the best in FF for many of the players.OTTERO Pet Information :\nOttero is a pet that wears a DJ outfit. It is known for its unique looks and creative moves. His ability ‘Double Bubble’ provides additional EP while using a Treatment Weapons and Med Kit. At the initial phase, his ability can restore EP equal to 35% of recovered HP. Additionally, later in the game, you can increase 65% of the recovered health.")
        )
        info.add(Info(
            "Robo",
            "Robo is a robot-based pet that players can buy in FF. This pet possesses a skill called 'Wall Enforcement'. This skill adds a shield to the gloo wall, thereby adding 60 additional HP. It increases to 80 when the pet reaches Level 5.\nROBO Pet Information :\nSkill - Wall Enforcement Wall Enforcement adds a shield to the gloo wall, which provides an additional 60 HP. This skill is gradually enhanced as the level rises. It adds a shield to the gloo walls at the highest level, which provides an additional 100 HP.")
        )
        info.add(Info(
            "Rockie",
            "Rockie pet that is mostly used by players who have the Time Turner active skill. Rockie is probably one of the most used pets in FF by players who have active skills. Rockie's skill is called Stay Chill and what it does is decrease the cooldown time of an active skill by 15%.\nROCKIE Pet Information :\nIn the clash squad mode, the lower cooldown is one of the elements possible with Rockie. Surprisingly, one Rockie pet has the ability to alter the cooldown time in the game. The cooldown of the character’s ability drops to 15% at the maximum level. As the time of writing this, there are over ten pets available in the game. The pets can easily be purchased from the in-game shop with or without using diamonds.")
        )
        info.add(Info(
            "Sensai Tig",
            "Sensei Tig is the latest addition to the Free Fire roster with a unique ability called 'Nimble Ninja'. At the base level of this ability, it can reduce the duration of enemies man-marking skill by 30%.")
        )
        info.add(Info(
            "Shiba",
            "Shiba is a pet based on a dog. Shiba has a skill called 'Mushroom Sense'.It marks one surrounding mushroom every 180 seconds. This marking lasts for every 30 seconds.After the pet reaches Level 5, it does the same every 150 seconds.\nSHIBA Pet Information :\nShiba is a pet that can be obtained only through events or direct purchase through the store. Its ability is called {Mushroom Sense} which marks a mushroom on the map every {180]150|120} seconds. Shiba is an adorable dog that wears a black costume which has wings, and has a passive ability called 'Mushroom Sense'. This lets him mark one of the surrounding mushrooms on the map every 180 seconds, with each mark lasting 30 seconds.")
        )
        info.add(Info(
            "Spirit Fox",
            "Spirit Fox has an ability called Well Fed. The ability can restore 4 extra HPs when using a health pack at its default level (level 1). When it is maximized to pet level 7 and skill level 3, Spirit Fox can restore an extra 10 HP when using a health pack.\nSPIRIT FOX Pet Information :\nSpirit Fox is a great pet for aggressive players who like to engage in fights and push rank. It can help these players to gain extra HPs while applying medkits, allowing them to ambush enemies much faster as their HP level fills up quicker.")
        )
        info.add(Info(
            "Yeti",
            "Yeti comes with the Frost Fortress ability. It reduces the damage inflicted by explosives by 15% at the first level. However, it will only come into effect every 150 seconds.")
        )
        info.add(Info(
            "Zasil",
            "These pets surely make it more fun to play. Nevertheless, the new pet that will be coming in the OB33 update is named Zasil. It is a pink-colored pet and is based on the animal named Axolotl.")
        )
        info.add(Info(
            "Falco",
            "Falco is useful for reaching air distances quickly at the start of a game which is exceptionally useful in Ranked games where the first to pick up a weapon makes the call. One thing that should be noted is that having more Falco's on a team does not improve anything. Instead, the highest level of Falco ability on the team will be used. (Pet abilities do not stack)FALCO Pet Information :\nFalco has an ability called Skyline Spree. At its primary stage, this capability provides a 15 percent increase in gliding pace and a 25 percent increase in diving speed after the player's parachute is opened. These results extend to the whole squad. At peak pet level 7, the speed of gliding increases by 45 percent, while the rate of diving increases by 50 percent.")
        )
        info.add(Info(
            "Fang",
            "The ability of the new Fang pet is called the Wolfpack bond. The skill will give you 30 EP if your HP is full or 15 HP if your HP isn't full whenever one of your teammates dies with a 25-second cooldown at skill level 3.")
        )
        info.add(Info(
            "Finn",
            "Finn is based on a shark and is the 22nd pet to be added to Free Fire MAX.")
        )
        info.add(Info(
            "Flash",
            "The skill of Flash is called Steel Shell (resembling the protective turtle shell). It will create an advantage for the pet skill users by damage reduction. Basically on equipping the Flash pet skill, players will get reduced damage from behind.")
        )
        info.add(Info(
            "Hoot",
            "Hoot has a unique ability called 'Far-Sighted'. It has no skill to cool down. Hoot can increase the range and time duration of scanning items and skills. However, the skill can be upgraded to use it to the fullest.")
        )

        val position = intent.getIntExtra("position",0)
        binding.txtTitle.text = info[position].title
        binding.txtInfo.text = info[position].info
        binding.imgMain.setImageResource(intent.getIntExtra("image",0))
        binding.btnClaim.setOnClickListener {
            showInter(object :OnAdCloseListener{
                override fun onClose() {
                    Intent(this@PetsInfoActivity,IDActivity::class.java).apply {
                        putExtra("gridLayout","gridLayout")
                        putExtra("image",intent.getIntExtra("image",0))
                        startActivity(this)
                    }
                }
            })
        }
        binding.btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }
}