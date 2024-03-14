package com.example.mobilkalab1


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.mobilkalab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var text = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        setup()

    }


    private fun setup() {
        with(binding) {
            btnFirstScreen.setOnClickListener {
                launchFirstScreen()
            }
            btnSecondScreen.setOnClickListener {
                launchSecondScreen()
            }
            editText.addTextChangedListener(
                object : TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    }

                    override fun onTextChanged(
                        changeText: CharSequence?,
                        p1: Int,
                        p2: Int,
                        p3: Int
                    ) {
                        text = changeText.toString()
                    }

                    override fun afterTextChanged(p0: Editable?) {

                    }
                },
            )
        }
    }


    private fun launchFirstScreen() {
        val intent = Intent(this, FirstScreenActivity::class.java)
        startActivity(intent)
    }

    private fun launchSecondScreen() {
        val intent = Intent(this, SecondScreenActivity::class.java)
        intent.putExtra(SAVED_TEXT, text)
        startActivity(intent)
    }

    companion object {
        private const val SAVED_TEXT = "saved_text"
    }
}