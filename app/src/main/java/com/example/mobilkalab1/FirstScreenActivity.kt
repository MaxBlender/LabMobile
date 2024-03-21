package com.example.mobilkalab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobilkalab1.databinding.ActivityFirstScreenBinding

class FirstScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivityFirstScreenBinding

    private var flagImage = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstScreenBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        setup()
    }

    fun setup() {
        with(binding) {
            btnChangeImage.setOnClickListener {
                changeImage()
            }
            btnBack.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
            toolbar.setNavigationOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
            ivImage.setImageResource(R.drawable.gabe)
        }
    }

    private fun changeImage() {
        with(binding) {
            flagImage = if (flagImage) {
                ivImage.setImageResource(R.drawable.gabe)
                !flagImage
            } else {
                ivImage.setImageResource(R.drawable.pudge)
                !flagImage
            }
        }
    }
}