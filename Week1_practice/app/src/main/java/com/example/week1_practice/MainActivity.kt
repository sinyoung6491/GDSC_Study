package com.example.week1_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.week1_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.toast.setOnClickListener {
            Toast.makeText(applicationContext, "버튼 누름",Toast.LENGTH_LONG).show()
        }
        binding.button.setOnClickListener {
            var text = binding.edittext.text.toString()
            binding.output.text = "반영 : ${text}"
        }
    }
}