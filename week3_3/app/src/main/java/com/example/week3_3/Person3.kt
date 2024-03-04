package com.example.week3_3

class Person3(var name:String) {
    var age:Int? = null
    lateinit var address:String

    constructor(name:String, age:Int):this(name){ //이미 기본 생성자에 속성 있으면 this필요

    }
}