package com.example.week7_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.get
import com.example.week7_3.databinding.ActivityMainBinding
import com.example.week7_3.databinding.Part1Binding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    //lateinit var viewbinding: Part1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        //viewbinding = Part1Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            findViewById<TextView>(R.id.output1).text = "강신영"
            findViewById<TextView>(R.id.output2).text = "010 1234 1004"

        }
    }
}