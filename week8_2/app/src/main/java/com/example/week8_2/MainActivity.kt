package com.example.week8_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.week8_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            val person1 = Person()
            person1?.name = "홍길동1"
            person1?.age = 20
            person1?.mobile = "010-1000-1000"
            //위와 아래 동일한 결과(아래가 더 간결함)
            val person2:Person? = Person().apply { //apply까지 적용하고 person2로 반환
                name = "홍길동1"
                age = 20
                mobile = "010-1000-1000"
            }

            showToast("이름 : ${person2?.name}")
            showToast("나이 : ${person2?.age}")
            showToast("전화번호 : ${person2?.mobile}")
            //위와 아래 동일
            with(person2!!){ //with 파라미터가 객체 지정
                showToast("이름 : ${name}")
                showToast("나이 : ${age}")
                showToast("전화번호 : ${mobile}")
            }

            if (person2 != null){
                showToast("이름 : ${person2.name}")
                showToast("나이 : ${person2.age}")
                showToast("전화번호 : ${person2.mobile}")
            } else {
                showToast("사람 객체가 null입니다.")
            }
            //위와 아래 동일(아래 더 간결)
            person2?.let{
                showToast("이름 : ${it.name}")
                showToast("나이 : ${it.age}")
                showToast("전화번호 : ${it.mobile}")
            } ?: run{
                showToast("사람 객체가 null입니다.")
            }
            //아래도 동일
            person2?.run {
                showToast("이름 : ${name}")
                showToast("나이 : ${age}")
                showToast("전화번호 : ${mobile}")
            } ?: run{
                showToast("사람 객체가 null입니다.")
            }

            val person3 = Person()
            if(person3.name == null){
                showToast("사람 객체의 age 속성이 null입니다.")
            }

            val person4 = Person()
            person4.also {
                if(it.name == null){
                    showToast("사람 객체의 name 속성이 null입니다.")
                }
                it.name = "홍길동4"
                if(it.age == null){
                    showToast("사람 객체의 age 속성이 null입니다.")
                }
                it.age = 20
            }
        }
    }
    fun showToast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}