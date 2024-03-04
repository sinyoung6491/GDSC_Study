package com.example.week3_3

class Person(var name:String?) { //괄호에 있는거 자동으로 속성 추가
    var age:Int? = null
    lateinit var address:String

    init {
        println("생성자가 호출됨")
    } // 파라미터가 없는 기본 생성자에 코드를 부여해주고 싶을 때 init사용
}