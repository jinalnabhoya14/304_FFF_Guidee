package com.example.dailydiamond.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log
import com.example.dailydiamond.ad.getAfterCallStatus
import com.example.dailydiamond.ui.activity.AfterCallActivity

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (context.getAfterCallStatus()) {
            val action = intent.action
            if (action != null && action == TelephonyManager.ACTION_PHONE_STATE_CHANGED) {
                val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)
                if (state != null && state == TelephonyManager.EXTRA_STATE_IDLE) {
                    Log.e("Tag", "Call ended")
                    val i = Intent(context, AfterCallActivity::class.java)
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(i)
                }
            }
            Log.e("TAG", "onReceive: " + TelephonyManager.ACTION_PHONE_STATE_CHANGED)
        }
    }
}