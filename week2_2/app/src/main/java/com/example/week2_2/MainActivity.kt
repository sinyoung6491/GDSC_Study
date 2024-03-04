package com.example.week2_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week2_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            show("안녕")
        }
        binding.button2.setOnClickListener {
            val firstStr = binding.input1.text.toString()
            val seconsStr = binding.input2.text.toString()

            val first = firstStr.toInt()
            val second = seconsStr.toInt()

            val resutl = add(first,second)
            binding.output1.text = "더하기 결과 : $resutl"
        }
        binding.button3.setOnClickListener {
            val result = add(getFirst(),getSecond())
            binding.output1.text = "더하기 결과 : $result"

            val result2 = add2(a=10)
            sum(10,20,30)
        }
    }
    fun sum(vararg inputs:Int):Int{
        var output = 0
        for (num in inputs){
            output = output + num
        }
        return output
    }

    fun getFirst():Int {
        val firstStr = binding.input1.text.toString()
        return firstStr.toInt()
    }
    fun getSecond():Int {
        val secondStr = binding.input2.text.toString()
        return secondStr.toInt()
    }

    fun show(message: String){
        println("버튼이 눌렸어요 : $message")
    }
    fun add(a:Int, b:Int):Int{
        return a+b
    }
    fun add2(a:Int, b:Int=0):Int{
        return a+b
    }
}