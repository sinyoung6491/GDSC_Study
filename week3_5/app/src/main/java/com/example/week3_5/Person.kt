package com.example.week3_5

import android.widget.TextView

open class Person(open var name: String?) {
    var age:Int? = null
    var address:String? = null

    constructor(name:String?, age:Int?, address:String?):this(name){
        println("Person의 생성자 호출됨")

        this.age = age
        this.address = address
    }

    open fun walk(output: TextView){ //파라미터로 ui 객체를 전달할 수 있다.
        println("걷는다.")
        output.text = "사람이 걷는다."
    }

}