package com.example.tiptime

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val cost = binding.costText.text.toString().toDoubleOrNull()
        if (cost == null || cost == 0.0) {
            displayTip(0.0)
            return
        }

        val roundTip = binding.switchRound.isChecked
        val percentage = when (binding.radioGroupOpinion.checkedRadioButtonId) {
            R.id.radio_amazing -> 0.2
            R.id.radio_good -> 0.18
            else -> 0.15
        }

        var tip = cost * percentage
        if (roundTip) {
            tip = ceil(tip)
        }

        displayTip(tip)
    }

    private fun displayTip(tip: Double) {
        binding.total.text =
            getString(R.string.text_total, NumberFormat.getCurrencyInstance().format(tip))
    }
}