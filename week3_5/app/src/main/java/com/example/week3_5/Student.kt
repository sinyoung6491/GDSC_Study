package com.example.week3_5

import android.widget.TextView

class Student(override var name:String?) : Person(name) {
    constructor(name: String?, age:Int?, address:String?):this(name){
        println("Student 생성자 호출됨")

        this.age = age
        this.address = address

    }
    override fun walk(output: TextView){ //파라미터로 ui 객체를 전달할 수 있다.
        output.text = "학생이 걷는다."
    }
}