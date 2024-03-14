package com.example.mobilkalab1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilkalab1.databinding.ActivitySecondScreenBinding


class SecondScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondScreenBinding
    private lateinit var text: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        text = intent?.extras?.getString(SAVED_TEXT) ?: "Пусто"
        binding = ActivitySecondScreenBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        setup()
    }

    private fun setup() {
        with(binding) {
            toolbar.setNavigationOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
            tvMessage.isSelected = true
            if (text != "") {
                tvMessage.text = text
            } else {
                tvMessage.text = "Пусто"
            }
            btnBack.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    companion object {
        private const val SAVED_TEXT = "saved_text"
    }
}