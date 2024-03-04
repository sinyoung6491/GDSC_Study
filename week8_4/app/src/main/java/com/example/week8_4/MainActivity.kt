package com.example.week8_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week8_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var degrees = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imageView.setOnClickListener{
            //var matrix = Matrix()
            degrees += 45.0f
            if(degrees >= 360.0f){
                degrees = 0f
            }

            binding.imageView.rotation = degrees
        }
    }
}