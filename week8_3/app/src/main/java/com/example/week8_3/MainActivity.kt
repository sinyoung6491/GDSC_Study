package com.example.week8_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.FrameLayout
import com.example.week8_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var startX = 0.0f
    var startY = 0.0f

    var leftMargin = 0
    var topMargin = 0

    var carWidth = 0.0f
    var carHeight = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        carWidth = resources.getDimension(R.dimen.car_width)
        carHeight = resources.getDimension(R.dimen.car_height)
        binding.carImageView.setOnTouchListener { v, event ->
            when(event.action){
                MotionEvent.ACTION_DOWN -> {
                    println("손가락 눌림")

                    startX = event.x
                    startY = event.y
                }
                MotionEvent.ACTION_MOVE -> {
                    println("손가락 움직임")

                    val diffX = event.x - startX
                    val diffY = event.y - startY

                    leftMargin += diffX.toInt()
                    topMargin += diffY.toInt()

                    val layoutParams = FrameLayout.LayoutParams(
                        carWidth.toInt(),carHeight.toInt()
                    )
                    layoutParams.leftMargin = leftMargin
                    layoutParams.topMargin = topMargin

                    binding.carImageView.layoutParams = layoutParams
                }
                MotionEvent.ACTION_UP -> {
                    println("손가락 뗌")
                }
            }
            return@setOnTouchListener true
        }
    }
}