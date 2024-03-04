package com.example.week6_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week6_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mainbtn.setOnClickListener {
            layoutInflater.inflate(R.layout.part1,binding.container, true)
        }
    }
}