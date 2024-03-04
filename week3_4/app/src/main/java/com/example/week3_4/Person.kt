package com.example.week3_4

open class Person(var name: String?) {
    var age:Int? = null
    var address:String? = null

    constructor(name:String?, age:Int?, address:String?):this(name){
        println("Person의 생성자 호출됨")

        this.age = age
        this.address = address
    }

}