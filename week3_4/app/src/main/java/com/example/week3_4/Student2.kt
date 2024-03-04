package com.example.week3_4

class Student2 : Person {
    constructor(alias:String?,age:Int?, address:String?):super(alias) {
        println("Student2 생성자 호출됨")

        this.age = age
        this.address = address
    }
}