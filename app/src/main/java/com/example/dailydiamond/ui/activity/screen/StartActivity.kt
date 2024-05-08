package com.example.dailydiamond.ui.activity.screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dailydiamond.R
import com.example.dailydiamond.databinding.ActivityStartBinding
import com.example.dailydiamond.ui.activity.BaseActivity
import com.example.dailydiamond.ui.activity.MainActivity

class StartActivity : BaseActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
    }

    private fun initListener() {
        binding.start.setOnClickListener {
            Intent(this,MainActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}