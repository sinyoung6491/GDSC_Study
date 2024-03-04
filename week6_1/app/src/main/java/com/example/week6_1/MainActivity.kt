package com.example.week6_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week6_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            val calc1 = Calc()
            val result = calc1.add(10,10)

            binding.output1.text = "더하기 결과 : ${result}"
        }
        binding.btn2.setOnClickListener {
            val calc1 = object : Calculator{
                override fun add(a:Int, b:Int):Int{
                    return a+b
                } // 한번 사용할 객체
            }
        }
        binding.btn3.setOnClickListener {
            val calc1 = object : CalcAdapter(){
                override fun add(a:Int, b:Int):Int {
                    return a+b
                }
            }
        }
        //<버튼위젯>.setOnClickListener({ v -> println("버튼 클릭됨")})
    }
}