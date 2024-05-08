package com.example.dailydiamond.ui.activity.screen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailydiamond.R
import com.example.dailydiamond.databinding.ActivityLanguageBinding
import com.example.dailydiamond.ui.activity.BaseActivity
import com.example.dailydiamond.ui.adapter.LanguageAdapter
import com.example.dailydiamond.ui.model.Language
import com.example.dailydiamond.util.TinyDB
import java.util.Locale


class LanguageActivity : BaseActivity() {

    private lateinit var binding: ActivityLanguageBinding
    private var adapter : LanguageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
        initListener()
    }

    private fun initListener() {
        binding.btnDone.setOnClickListener {
            Intent(this,IntroActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    private fun initAdapter() {
        val languageList = ArrayList<Language>()
        languageList.add(Language(R.drawable.ic_us,"English","en"))
        languageList.add(Language(R.drawable.ic_indian,"Hindi","hi"))
        languageList.add(Language(R.drawable.ic_german,"German","de"))
        languageList.add(Language(R.drawable.ic_spanish,"Spanish","es"))
        languageList.add(Language(R.drawable.ic_italian,"Italian","it"))
        languageList.add(Language(R.drawable.ic_african,"African","af"))
        languageList.add(Language(R.drawable.ic_arabic,"Arabic","ar"))
//        languageList.add(Language(R.drawable.ic_french,"French","fr"))
//        languageList.add(Language(R.drawable.ic_portuguese,"Portuguese","pt"))
//        languageList.add(Language(R.drawable.ic_turkish,"Turkish","tr"))
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@LanguageActivity)
            adapter = LanguageAdapter(this@LanguageActivity,languageList,object : LanguageAdapter.OnClickLanguage{
                override fun onClick(language: Language) {
                    updateLocale(Locale(language.code))
                    TinyDB(this@LanguageActivity).putString("langCode", language.code)
                }
            })
            recyclerView.adapter = adapter
        }
    }
}