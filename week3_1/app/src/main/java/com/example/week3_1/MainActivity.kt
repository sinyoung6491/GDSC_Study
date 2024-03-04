package com.example.week3_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week3_1.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        button.setOnClickListener {
            val addFunc = {a:Int,b:Int -> a + b}
            val result = calc(10,10,addFunc)

            val addFunc2 = getOperator("add")
            val result2 = calc(20,20,addFunc2!!)

            val multiply = {a:Int, b:Int -> a + b}
            val multiplu2:(Int,Int)->Int = {a, b -> a + b}

            val show1 = { println("show 함수 호출됨.")}
            val show2:()->Unit = { println("show 함수 호출됨.")}
            // show1, show2는 변수에 람다식를 할당한 것
            // 함수 show와 show1, show2는 동일
            // show1은 함수 자료형 생략한 형태, show2는 함수 자료형 표기

            val sum = fun (a:Int, b:Int):Int {return a +b}
            sum(10,10)
            // 변수 sum에 익명함수를 바로 할당한 것

            doAction(fun ():Int{
                println("전달된 함수 호출됨.")
                return 10
            })
            //마지막 파라미터가 함수인 경우 -> 해당 함수를 뒤로 뺄 수 있다. (람다식으로 만들어서 가능)
            //위에 doAction 호출 축약
            doAction () {->
                println("전달된 함수 호출됨.")
                10
            } //화살표의 왼쪽 파라미터 부분에 인수가 존재하지 않으므로 화살표 생략 가능
              //소괄호도 비어있기 때문에 생략 가능
              //람다식에서 값을 반환하고 싶을때 -> return사용하지 않고 숫자만 넣으면 반환가능
            doAction{
                println("전잘된 함수 호출됨.")
                return@doAction 10
            } //람사식에서 중활호는 범위한정을 해주지 않으므로 그냥 return을 사용하면 벙위를 넘어간다.
              //따라서 라벨(@doAction)을 통해 범위를 한정해줘야 람다식까지만 return하게 된다.

        }
    }
    fun show():Unit {
        println("show 함수 호출됨.")
    } // 자료형이 없을 때는 Unit을 사용, 생략도 가능
    fun doAction(action:()->Int){
        println("doAction 호출됨.")
        val result = action()
    }

    fun calc(first:Int,second:Int,oper:(Int, Int)->Int):Int{
        return oper(first,second)
    }
    fun getOperator(name:String):((Int,Int)->Int)?{
        var oper:((Int,Int)->Int)? = null
        if (name == "add"){
            oper = {a:Int,b:Int -> a + b}
        }
        else if (name == "subtract"){
            oper = {a:Int, b:Int -> a - b}
        }
        return oper
    }
}