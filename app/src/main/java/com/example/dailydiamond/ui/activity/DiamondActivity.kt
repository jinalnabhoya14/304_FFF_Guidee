package com.example.dailydiamond.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dailydiamond.R
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.adSmall
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityDiamondBinding

class DiamondActivity : BaseActivity() {
    private lateinit var binding: ActivityDiamondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiamondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ad170.apply {
            let { ad170(it) }
            setOnClickListener { nativeClick() }
        }
        binding.ad40sdp.apply {
            let { adSmall(it) }
            setOnClickListener { nativeClick() }
        }
        onBackPressedDispatcher.addCallback(this,object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                nativeClick()
                finish()
            }
        })

        binding.apply {
            layout1.setOnClickListener {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@DiamondActivity,DiamondInfoActivity::class.java).apply {
                            val layout1 = "Choosing a landing point is only the first step to victory.Although it may seem trivial, it is not.\nDetermining where to stare the game correctly.\nThe important" + " thing is to choose a place that is isolated from other players, very close to the city, but not so close.\nSo, that best option is to fall from the town, observe where " + "other people full and enter to explore.it is very important that we don't expose ourselves too much before we don't have the proper equipment, especially when we are " + "everywhere both quantity and quality are robbed, there will be players in many places."
                            putExtra("info",layout1)
                            putExtra("title",ContextCompat.getString(this@DiamondActivity,R.string.txt_choose_the_correct_landing_point))
                            startActivity(this)
                        }
                    }
                })
            }
            layout2.setOnClickListener {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@DiamondActivity,DiamondInfoActivity::class.java).apply {
                            val info = "FF has a variety of in-game achievements that players can complete to earn rewards such as diamonds, gold coins, character skins, and weapon skins.\nAchievements are categorized into different types, such as combat, survival, and teamwork.\nHere are some tips for completing in-game achievements in FF:\n1. Check the achievement list: \nOpen the achievement list and check which achievements are available. Focus on the ones that offer rewards you are interested in.\n2. Choose achievements that match your playstyle:\nEach achievement requires different skills and strategies, so choose the ones that match your playstyle.\n3. Set achievable goals: \nSome achievements require a lot of effort and time to complete, so set achievable goals and focus on completing them one at a time.\n4. Play with friends: \nSome achievements require you to play with friends or in a team. Playing with friends can make completing these achievements easier and more enjoyable."
                            putExtra("info",info)
                            putExtra("title",ContextCompat.getString(this@DiamondActivity,R.string.use_the_vehicle_carefully))
                            startActivity(this)
                        }
                    }
                })
            }
            layout3.setOnClickListener {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@DiamondActivity,DiamondInfoActivity::class.java).apply {
                            val info = "If there is no enemy in sight, it is a good idea to explore attractions such as watch towers, containers, buttle es or militry tents. in these places, there are usually a lot of loot.\nit is not very wish to eplore these areas from the beginning, but if we do it in the middle of the game, there will always be a lot to do.\n There will definitely be fewer players lurking to destroy us.\nIn such places, kits are usually found to improve bulletproof vests. please pay attention when exploring, because although you can wear a first-level vest, it is stongly recommended that you upgrade it as soon as possible. \n The last player will always have powerful weapons."
                            putExtra("info",info)
                            putExtra("title",ContextCompat.getString(this@DiamondActivity,R.string.participate_in_game_event))
                            startActivity(this)
                        }
                    }
                })
            }
            layout4.setOnClickListener {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@DiamondActivity,DiamondInfoActivity::class.java).apply {
                            val info = "FF offers a variety of missions that players can complete to earn rewards, including character vouchers, weapon skins, and diamonds.\n The missions can be found in the missions section of the game and are updated regularly with new challenges and rewards.\nThere are different types of missions in FF, including daily missions, weekly missions, and event missions.\nDaily missions reset every day and offer smaller rewards, while weekly missions reset every week and offer larger rewards. Event missions are tied to specific in-game events and offer unique rewards.\nHere are some tips for completing missions in FF:\nCheck the mission requirements: Some missions have specific requirements, such as playing a certain game mode or using a specific character. Make sure to check the requirements before starting the mission to avoid wasting time.\nPlay with friends: \n Some missions require you to play with friends or in a team. Playing with friends can make completing these missions easier and more enjoyable.\nComplete multiple missions at once:\n Some missions have similar objectives, so try to complete multiple missions at once to save time."
                            putExtra("info",info)
                            putExtra("title",ContextCompat.getString(this@DiamondActivity,R.string.daily_login_rewards))
                            startActivity(this)
                        }
                    }
                })
            }
            layout5.setOnClickListener {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@DiamondActivity,DiamondInfoActivity::class.java).apply {
                            val info = "Fire, here is some information about the daily login rewards:\nFF offers daily login rewards to players who log in to the game on a daily basis. These rewards can include various items such as character vouchers, weapon skins, and diamonds.\n The rewards increase in value the more consecutive days you log in, up to a maximum of 30 days. If you log in for 30 consecutive days, you can earn up to 100 diamonds as a reward.\nHere is an example of the daily login rewards for a 7-day consecutive login:\nDay 1: Character Voucher\nDay 2: Diamond Royale Voucher\nDay 3: Weapon Royale Voucher\nDay 4: Gold Royale Voucher\nDay 5: Pet Food\nDay 6: Memory Fragment\nDay 7: Weapon Skin\nPlease note that the daily login rewards can vary based on the region and the current in-game events. It's always a good idea to check the in-game events section for the latest information on the daily login rewards."
                            putExtra("info",info)
                            putExtra("title",ContextCompat.getString(this@DiamondActivity,R.string.complete_mission))
                            startActivity(this)
                        }
                    }
                })
            }
            layout6.setOnClickListener {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@DiamondActivity,DiamondInfoActivity::class.java).apply {
                            val info = "In-game events are a great way to earn rewards and experience new content in FF. The game regularly hosts events that allow you to complete tasks and challenges in exchange for rewards such as skins, characters, and other items. Here are some tips for participating in in-game events in FF:\n1. Check the events tab: The events tab in the main menu will show you all the ongoing events and their requirements. Check this tab regularly to see what events are available and what rewards you can earn.\n2. Complete event tasks: Each event has specifictasks and challenges that you need to complete to earn rewards. Make sure to complete all the tasks to maximize your rewards.\n3. Participate in limited-time events: Some events are only available for a limited time. Make sure to participate in these events as soon as they become available to earn the maximum rewards.\n4. Use event items: Some events give you items that can only be used during the event. Make sure to use these items to complete the event tasks and earn rewards."
                            putExtra("info",info)
                            putExtra("title",ContextCompat.getString(this@DiamondActivity,R.string.explore_mileteary_sites))
                            startActivity(this)
                        }
                    }
                })
            }
            layout7.setOnClickListener {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@DiamondActivity,DiamondInfoActivity::class.java).apply {
                            val info = "These vehicles are used to quickly move to other places, where there are a lot of loot and can also pass the players we found on the road without players. If we make too much sound, other players will be able to hear us. Therefore, Please be careful when using cars, trucks and motorcycles so as not to reveal our location."
                            putExtra("info",info)
                            putExtra("title",ContextCompat.getString(this@DiamondActivity,R.string.complate_in_game_archivements))
                            startActivity(this)
                        }
                    }
                })
            }
            btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
        }
    }
}