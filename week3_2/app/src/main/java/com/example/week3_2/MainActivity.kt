package com.example.week3_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week3_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val a = 10
            val b = 20
            var max:Int

            if(a > b){
                max = a
            }
            else{
                max = b
            } //위에 if문을 아래로 줄임 //*축약이 필수는 아님 권장한다
            max = if (a>b) a else b


            when(max){
                10 -> {
                    println("max가 10입니다.")
                }
                20 -> {
                    println("max가 20입니다.")
                }
                30,40 -> {
                    println("max가 30이거나 40입니다.")
                }
                in 50..60 ->{
                    println("max가 50부터 60까지 중의 하나입니다.")
                }
                else -> {
                    println("max가 10도 20도 아닙니다.")
                }
            }

        }
    }
}