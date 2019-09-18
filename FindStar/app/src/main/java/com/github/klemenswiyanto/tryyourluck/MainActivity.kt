package com.github.klemenswiyanto.tryyourluck

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.github.klemenswiyanto.tryyourluck.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val onid = 17301516
    private val offid = 17301515
    private lateinit var ViewSelect: View
    private var idselect = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val box: List<Int> = listOf(
            binding.ktk1.id, binding.ktk2.id, binding.ktk8.id,
            binding.ktk4.id, binding.ktk5.id, binding.ktk6.id,
            binding.ktk7.id, binding.ktk8.id, binding.ktk9.id
        )
        idselect = box[Random.nextInt(0, 8)]
        setListeners()
    }

    private fun setLogic(view: View) {
        if(view.id == idselect) {
            setBackground(view, onid)
            ViewSelect = view
            Toast.makeText(this, "Selamat... Anda Menang!!! Ketuk bintang untuk mengulang", Toast.LENGTH_LONG).show()
            ViewSelect.setOnClickListener {
                reset()
            }
        } else setBackground(view, offid)
    }

    private fun setBackground(view: View, buttonIcon: Int) {
        view.setBackgroundResource(buttonIcon)
    }

    private fun reset() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val box: List<Int> = listOf(
            binding.ktk1.id, binding.ktk2.id, binding.ktk3.id,
            binding.ktk4.id, binding.ktk5.id, binding.ktk6.id,
            binding.ktk7.id, binding.ktk8.id, binding.ktk9.id
        )
        idselect = box[Random.nextInt(0, 8)]

        val textBox1 = findViewById<TextView>(R.id.ktk1)
        val textBox2 = findViewById<TextView>(R.id.ktk2)
        val textBox3 = findViewById<TextView>(R.id.ktk3)
        val textBox4 = findViewById<TextView>(R.id.ktk4)
        val textBox5 = findViewById<TextView>(R.id.ktk5)
        val textBox6 = findViewById<TextView>(R.id.ktk6)
        val textBox7 = findViewById<TextView>(R.id.ktk7)
        val textBox8 = findViewById<TextView>(R.id.ktk8)
        val textBox9 = findViewById<TextView>(R.id.ktk9)

        val clickableViews: List<View> =
            listOf(textBox1, textBox2, textBox3, textBox4, textBox5, textBox6, textBox7, textBox8,
                textBox9)

        for (item in clickableViews) {
            item.setOnClickListener {
                setLogic(it)
            }
            item.setBackgroundColor(Color.WHITE)
        }
    }

    private fun setListeners() {
        val textBox1 = findViewById<TextView>(R.id.ktk1)
        val textBox2 = findViewById<TextView>(R.id.ktk2)
        val textBox3 = findViewById<TextView>(R.id.ktk3)
        val textBox4 = findViewById<TextView>(R.id.ktk4)
        val textBox5 = findViewById<TextView>(R.id.ktk5)
        val textBox6 = findViewById<TextView>(R.id.ktk6)
        val textBox7 = findViewById<TextView>(R.id.ktk7)
        val textBox8 = findViewById<TextView>(R.id.ktk8)
        val textBox9 = findViewById<TextView>(R.id.ktk9)

        val clickableViews: List<View> =
            listOf(textBox1, textBox2, textBox3, textBox4, textBox5,
                textBox6, textBox7, textBox8, textBox9)

        for (item in clickableViews) {
            item.setOnClickListener {
                setLogic(it)
            }
        }
    }
}
