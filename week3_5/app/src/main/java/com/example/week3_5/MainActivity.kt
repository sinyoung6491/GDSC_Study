package com.example.week3_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week3_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var person:Person? = null
    enum class PersonType {
        PERSON, STUDENT //PERSON : 사람, STUDENT : 학생
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.createPersonButton.setOnClickListener {
            makePerson(PersonType.PERSON)
        }
        binding.createStudentButton.setOnClickListener {
            makePerson(PersonType.STUDENT)
        }
    }
    fun makePerson(type:PersonType){
        val name = binding.input1.text.toString()
        val age = binding.input2.text.toString().toInt()
        val address = binding.input3.toString()

        when(type){
            PersonType.PERSON -> {
                person = Person(name, age, address)
                binding.output1.text = "사람 객체 만들어짐 : ${person?.name}"
                binding.output2.setImageResource(R.drawable.person)

                person?.walk(binding.output1)
            }
            PersonType.STUDENT -> {
                person = Student(name, age, address)
                binding.output1.text = "학생 객체 만들어짐 : ${person?.name}"
                binding.output2.setImageResource(R.drawable.student)

                person?.walk(binding.output1)

            }
        }
    }
}