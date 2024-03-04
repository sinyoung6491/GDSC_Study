package com.example.week7_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week7_2.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            //array 만드는 법 4가지
            val names = arrayOf("홍길동1","홍길동2","홍길동3")
            val names2 = Array<String>(3,{ index -> "홍길동${index+1}"})
            val names3 = arrayOfNulls<String>(3)
            val names4 = emptyArray<String>()

            binding.output1.append("\nnames : ${Arrays.toString(names)}")
            binding.output1.append("\nnames2 : ${Arrays.toString(names2)}")
            binding.output1.append("\nnames3 : ${Arrays.toString(names3)}")
            binding.output1.append("\nnames4 : ${Arrays.toString(names4)}")


            //숫자 array 만들기
            val digits = intArrayOf(1,2,3)
            // digits.set(2,4) 아래랑 동일
            digits[2]=4 //index번호 2인 숫자 4로 바꾸기

            //val aDigit = digits.get(2) 아래랑 동일
            val aDigit = digits[2] //index번호 2인 숫자 aDigit에 넣기

            //배열 크기
            val digitCount = digits.count()
            val digitSize = digits.size
            binding.output1.append("\ndigits 배열 크기 : $digitCount")
            binding.output1.append("\ndigits 배열 크기 : $digitSize")

            val digits2 = digits.plus(5) //digits2에 숫자 5 추가된 digits 넣기
            val aIndex = digits2.indexOf(5) //숫자 5의 index번호 aIndex에 넣기
            val digits3 = digits2.sliceArray(1..aIndex) //index번호 1부터 aIndex까지 array로 나누어 digits3에 넣기
            binding.output1.append("\n배열3 : ${digits3.contentToString()}")//Arrays.toString(digits3) ${}안에꺼랑 동일
                                                                        //digits3 안에 있는거 전부 출력
            digits.forEachIndexed{ index, i ->
                binding.output1.append("\n#${index} : ${i}")
            } //index수에 맞게 index에 해당하는 숫자 출력하기
            //위와 아래 index와 값 출력하는거 동일함
            var elemIndex = 0
            for(elem in digits){ //digits에 있는 값을 elem에 하나씩 넣어서
                binding.output1.append("\n#${elemIndex} : ${elem}")
                elemIndex += 1
            }
            //아래도 위와 동일
            elemIndex = 0
            val iter = digits.iterator()
            while (iter.hasNext()){
                val elem = iter.next()
                binding.output1.append("\n#${elemIndex} : ${elem}")
                elemIndex += 1
            }

            val sortedArray = digits.sortedArray()
            val sortedArray2 = digits.sortedArrayDescending()

            //1보다 큰것만 필터링 해서 출력하는 것
            digits.filter { elem -> elem > 1 }.forEach{
                binding.output1.append("\n원소 : ${it}")
            }
        }

        binding.btn2.setOnClickListener{
            val names = listOf("홍길동1","홍길동2","홍길동3")
            //val names2 = List<String>(3,{index -> "홍길동${index+1}" })
            val names2 = List<String>(3) {index -> "홍길동${index+1}"} //위와 동일 이거 권장
            val names3 = mutableListOf<String>("홍길동1","홍길동2","홍길동3")
            val names4 = emptyList<String>()
            val names5 = arrayListOf<String>()
            val names6 = ArrayList<String>()
            //names.add("홍길동4")는 불가능 기본적으로 list는 변경 추가 불가능
            names3.add("홍길동4") //mutable로 해야 가능
            names3[1] = "홍길동5"
            binding.output1.append("\n${names3.joinToString()}")

            if(names3.contains("홍길동5")){ //names3에 "홍길동5가 있다면
                val aIndex = names3.indexOf("홍길동5")
                val names4 = names3.slice(0..aIndex)
                binding.output1.append("\n${names4.joinToString()}")
            }
        }
   }
}