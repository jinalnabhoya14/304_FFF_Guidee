package com.example.dailydiamond.ui.activity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.WindowInsetsControllerCompat
import com.zeugmasolutions.localehelper.LocaleHelperActivityDelegate
import com.zeugmasolutions.localehelper.LocaleHelperActivityDelegateImpl
import org.imaginativeworld.oopsnointernet.callbacks.ConnectionCallback
import org.imaginativeworld.oopsnointernet.dialogs.signal.NoInternetDialogSignal
import java.util.Locale

open class BaseActivity : AppCompatActivity() {

    private val localeDelegate: LocaleHelperActivityDelegate = LocaleHelperActivityDelegateImpl()
    var isLightTheme = true
    var hideNavigation = true
    var hideStatusBar = false

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState)
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            statusBarColor = Color.TRANSPARENT
        }

        setBlack()
        internetDialog()
    }

    fun internetDialog(){
        var nodialog: NoInternetDialogSignal? = null
        nodialog =
            NoInternetDialogSignal.Builder(
                this,
                lifecycle
            ).apply {
                dialogProperties.apply {
                    connectionCallback = object : ConnectionCallback { // Optional
                        override fun hasActiveConnection(hasActiveConnection: Boolean) {
                            if (!hasActiveConnection){
                                nodialog?.show()
                            }
                        }
                    }
                    cancelable = false // Optional
                    noInternetConnectionTitle = "No Internet" // Optional
                    noInternetConnectionMessage =
                        "Check your Internet connection and try again." // Optional
                    showInternetOnButtons = true // Optional
                    pleaseTurnOnText = "Please turn on" // Optional
                    wifiOnButtonText = "Wifi" // Optional
                    mobileDataOnButtonText = "Mobile data" // Optional
                    onAirplaneModeTitle = "No Internet" // Optional
                    onAirplaneModeMessage = "You have turned on the airplane mode." // Optional
                    pleaseTurnOffText = "Please turn off" // Optional
                    airplaneModeOffButtonText = "Airplane mode" // Optional
                    showAirplaneModeOffButtons = true // Optional
                }
            }.build()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            if (hideNavigation) {
                if (isLightTheme) {
                    this.window.decorView.systemUiVisibility = 12290
                } else {
                    this.window.decorView.systemUiVisibility = 4098
                }
            }
            if (hideStatusBar) {
                val decorView = this.window.decorView
                decorView.systemUiVisibility = 5638
            }
        }
        if (isLightTheme){
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setBlack() {
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            statusBarColor = Color.TRANSPARENT
        }
    }

    fun updateLocale(locale: Locale) {
        localeDelegate.setLocale(this, locale)
    }

}