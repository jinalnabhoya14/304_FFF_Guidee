package com.example.dailydiamond.ad

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import com.example.dailydiamond.util.TinyDB
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.UUID

private var _responseRoot: ResponseAd? = null

fun getResponse(context: Context): ResponseAd? {
    if (_responseRoot != null)
        return _responseRoot
    return TinyDB(context).getObject("adsJson", ResponseAd::class.java)
}

private var retrofit: Retrofit? = null

fun client(s: String): Retrofit {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
    retrofit = Retrofit.Builder()
        .baseUrl("https://manaager.s3.ap-south-1.amazonaws.com/$s/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    return retrofit as Retrofit
}

interface APIInterface {
    @GET("ad_manager.json")
    fun responseAdsDemo(): Call<ResponseAd?>?
}

interface OnInit {
    fun onInitComplete()
    fun onFail()
}

interface OnAdCloseListener {
    fun onClose()
}


fun Activity.initSplash(onInit: OnInit, appName: String) {
    val call: Call<ResponseAd?>? = client(appName).create(APIInterface::class.java).responseAdsDemo()
    call?.enqueue(object : Callback<ResponseAd?> {
        override fun onResponse(call: Call<ResponseAd?>, response: Response<ResponseAd?>) {
            Log.e("TAG", "onResponse:getJsonObject111 " + response.isSuccessful)
            if (response.isSuccessful) {
                _responseRoot = response.body()
                TinyDB(this@initSplash).putObject("adsJson", response.body())
                onInit.onInitComplete()
            }
        }

        override fun onFailure(call: Call<ResponseAd?>, t: Throwable) {
            t.printStackTrace()
            onInit.onFail()
        }
    })
}

fun Context.getAfterCallURL(): String {
    return getResponse(this)?.afterCallUrl ?: ""
}

fun Context.getAfterCallURLStatus(): Boolean {
    return getResponse(this)?.afterCallUrlStatus?.equals("ON") ?: true
}

fun Context.getAfterCallInterStatus(): Boolean {
    return getResponse(this)?.afterCallInterStatus?.equals("ON") ?: true
}

fun Context.getAfterCallStatus(): Boolean {
    return getResponse(this)?.afterCallScreenStatus?.equals("ON") ?: true
}

private fun Context.getWebSiteLink(): String {
    return getResponse(this)?.website ?: ""
}

fun AppCompatActivity.nativeClick() {
    val customIntent = CustomTabsIntent.Builder().build()
    customIntent.intent.data = Uri.parse(getWebSiteLink())
    callIntent(intent = customIntent.intent)
}

fun AppCompatActivity.showInter(onAdCloseListener: OnAdCloseListener) {
    val customIntent = CustomTabsIntent.Builder().build()
    customIntent.intent.data = Uri.parse(getWebSiteLink())
    callIntent(onAdCloseListener, customIntent.intent)
}

private fun <I, O> ComponentActivity.registerActivityResultLauncher(contract: ActivityResultContract<I, O>, callback: ActivityResultCallback<O>): ActivityResultLauncher<I> {
    val key = UUID.randomUUID().toString()
    return activityResultRegistry.register(key, contract, callback)
}


fun AppCompatActivity.callIntent(onInterstitialListener: OnAdCloseListener? = null, intent: Intent? = null) {
    try {
        var launcher: ActivityResultLauncher<Intent>? = null
        launcher = registerActivityResultLauncher(
            contract = ActivityResultContracts.StartActivityForResult(),
            callback = {
                onInterstitialListener?.onClose()
                launcher?.unregister()
            }
        )
        launcher.launch(intent)
    } catch (ex: Exception) {
    }
}

