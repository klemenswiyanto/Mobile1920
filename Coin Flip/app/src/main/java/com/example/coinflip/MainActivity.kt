package com.example.coinflip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.NullPointerException
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var resultText: TextView
    lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultText = findViewById(R.id.result_text) as TextView
        rollButton = findViewById(R.id.roll_button) as Button
        rollButton.setOnClickListener {
            flipCoin()
            Toast.makeText(this,"Fliping Coin", Toast.LENGTH_SHORT).show()
        }
    }


    private fun flipCoin() {

        val rand = Random().nextInt(2)+1
        val coin = if(rand == 1)"Head" else "Tail"
        resultText.text = coin.toString()
    }
}