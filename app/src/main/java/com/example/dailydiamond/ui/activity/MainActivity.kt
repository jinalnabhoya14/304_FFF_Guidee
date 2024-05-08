package com.example.dailydiamond.ui.activity

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.example.dailydiamond.ad.ExitDialogNative
import com.example.dailydiamond.ad.OnAdCloseListener
import com.example.dailydiamond.ad.ad170
import com.example.dailydiamond.ad.adBanner
import com.example.dailydiamond.ad.adSmall
import com.example.dailydiamond.ad.nativeClick
import com.example.dailydiamond.ad.showInter
import com.example.dailydiamond.databinding.ActivityMainBinding
import com.example.dailydiamond.ui.activity.screen.SettingActivity


class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
        binding.ad170.let { ad170(it) }
        binding.ad170.setOnClickListener {
            nativeClick()
        }
        binding.ad40sdp.let { adSmall(it) }
        binding.adBanner.let { adBanner(it) }

        if (!Settings.canDrawOverlays(this)) {
            sendToSetting()
        }

    }

    fun sendToSetting(){
        val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + packageName))
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        startActivityForResult(intent,123)
    }

    override fun startActivityForResult(intent: Intent, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
        if (requestCode == 123){
            storagePermission.launch(Manifest.permission.READ_PHONE_STATE)
        }
    }

    private val storagePermission = registerForActivityResult(ActivityResultContracts.RequestPermission()){}

    private fun initListener() {
        binding.apply {
            imgCharacter.setOnClickListener {
                showInter(object :OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@MainActivity,CharactersActivity::class.java).apply {
                            startActivity(this)
                        }
                    }
                })
            }
            imgPets.setOnClickListener {
                showInter(object :OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@MainActivity,PetsActivity::class.java).apply {
                            startActivity(this)
                        }
                    }
                })
            }
            imgBundle.setOnClickListener {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@MainActivity,BundlesActivity::class.java).apply {
                            startActivity(this)
                        }
                    }
                })
            }
            imgWeapon.setOnClickListener {
                showInter(object : OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@MainActivity,WeaponsActivity::class.java).apply {
                            startActivity(this)
                        }
                    }
                })
            }
            imgVehicle.setOnClickListener {
                showInter(object :OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@MainActivity,VehicleActivity::class.java).apply {
                            startActivity(this)
                        }
                    }
                })
            }
            imgEmotes.setOnClickListener {
                showInter(object :OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@MainActivity,EmotesActivity::class.java).apply {
                            startActivity(this)
                        }
                    }
                })
            }
            imgParachute.setOnClickListener {
                showInter(object :OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@MainActivity,ParachuteActivity::class.java).apply {
                            startActivity(this)
                        }
                    }
                })
            }
            imgDiamond.setOnClickListener {
                showInter(object :OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@MainActivity,DiamondActivity::class.java).apply {
                            startActivity(this)
                        }
                    }
                })
            }
            imgCalc.setOnClickListener {
                showInter(object :OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@MainActivity,DiamondCalcActivity::class.java).apply {
                            startActivity(this)
                        }
                    }
                })
            }
            btnSetting.setOnClickListener {
                showInter(object :OnAdCloseListener{
                    override fun onClose() {
                        Intent(this@MainActivity,SettingActivity::class.java).apply {
                            startActivity(this)
                        }
                    }
                })
            }
        }
        onBackPressedDispatcher.addCallback(this,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                val exitDialogNative = ExitDialogNative()
                exitDialogNative.show(supportFragmentManager, "")
            }
        })
    }
}