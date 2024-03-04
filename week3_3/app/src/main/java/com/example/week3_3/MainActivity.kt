package com.example.week3_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.week3_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            var name = binding.input1.text.toString()

            val calc1 = Calc() // 인스턴스 책체 생성하여 변수에 할당
            calc1.name = name // 클래스 안에 정의한 속성 접근

            show("계산기 객체 만들어짐 : ${calc1.name}")

            val person1 = Person(name)
            show("사람 객체 만들어짐 : ${person1.name}")

            val person2 = Person2("홍길동", 20, "서울시")

            val person3 = Person3("홍길동", 20)
        }
    }
    fun show(message:String){
        Toast.makeText(applicationContext,message,Toast.LENGTH_LONG).show()
    }
}