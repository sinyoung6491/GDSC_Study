package com.example.week3_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week3_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.createPersonButton.setOnClickListener {
            val name = binding.input1.text.toString()
            val age = binding.input2.text.toString().toInt()
            val address = binding.input3.toString()

            val person1 = Person(name,age,address)
            binding.output1.text = "사람 객체 만들어짐 : ${person1.name}"
        }
        binding.createStudentButton.setOnClickListener {
            val name = binding.input1.text.toString()
            val age = binding.input2.text.toString().toInt()
            val address = binding.input3.toString()

            val student1 = Student(name,age,address)
            binding.output1.text = "학생 객체 만들어짐 : ${student1.name}"
        }
    }
}