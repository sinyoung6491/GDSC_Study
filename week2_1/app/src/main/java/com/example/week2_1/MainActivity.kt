package com.example.week2_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week2_1.constants.mBonus
import com.example.week2_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var first:Int = 0
    var second:Int = 0

    companion object{
        const val BONUS = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.addbutton.setOnClickListener {
            val firstStr = binding.input1.text.toString()
            val secondStr = binding.input2.text.toString()

            first = firstStr.toInt()
            second = secondStr.toInt()

            val result = first + second + MainActivity.BONUS+ mBonus
            binding.output1.text = "결과 : $result"


            if(result == 20){
                binding.output1.text = "더하기 결과가 20입니다."
            }
            if(firstStr == "10"){
                binding.output1.append("\n 첫번째 입력된 값이 10입니다.")
            }

            val input1:Any = "안녕"
            val input2:Any = 10

            if(input1 is String){
                val output2:String = input1 as String
                binding.output1.text = "input1은 문자열 자료형입니다."
            }

            val output3:String? = input1 as String?
        }
    }
}