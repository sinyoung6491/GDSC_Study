package com.example.week2_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week2_3.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        button.setOnClickListener {
            //val result = add(10,10)
            val addFunc = {a:Int, b:Int -> a + b}
            //val result = addFunc(10,10)
            val result = calc(10,10,addFunc)

            val addFunc2 = getOperator("add")
            val result2 = calc(20,20,addFunc2!!)

            output1.text = "결과 : $result"

            val multiply = {a:Int, b:Int ->a + b}
            val multiply2:(Int, Int)->Int = { a, b ->a + b}

            val show1 = { println("show 함수 호출됨.")} //함수 show랑 show1이랑 같음
            val show2:()->Unit = { println("show 함수 호출됨.")} //show1은 함수 자료형 생략 show2는 함수 자료형 표시

            val sum = fun (a:Int,b:Int):Int {return a + b}
            sum(10,10)

            doAction(fun ():Int{
                println("전달된 함수 호출됨.")
                return 10
            })
            //위에 doAction 축약 가능
            //마지막 파라미터가 함수인 경우 해당 함수를 뒤로 뺄 수 있다. (람다식으로 만들어서 뺄 수 있다.)
            doAction () { -> // 왼쪽 파라미터 부분 없으니까 화살표도 생략 가능 ,소괄호도 생략가능
                println("전달된 함수 호출됨.")
                10 //람다식에서 값을 반환하고 싶을때 return사용하지 않고 숫자만 넣으면 반환 가능
            }
            doAction {
                println("전달된 함수 호출됨.")
                return@doAction 10 //람다식에서 중괄호는 범위 한정하지 않아서 return을 사용하면 범위 벗어남
                                    //따라서 @doAction해줘야(라벨) doAction 람다식까지만 return해준다는 의미
            }
        }
    }

    fun doAction(action:()->Int){
        println("doAction 호출됨.")
        val result = action()
    }

    fun show():Unit { //유닛은 생략가능
        println("show 함수 호출됨.")
    }

    fun getOperator(name:String):((Int,Int)->Int)?{
        var oper:((Int,Int)->Int)? = null
        if (name == "add"){
            oper = { a:Int, b:Int -> a + b}
        }
        else if (name == "subtract"){
            oper = {a:Int, b:Int -> a - b}
        }
        return oper
    }

    fun calc(first:Int, second:Int, oper:(Int,Int)->Int):Int{
        return oper(first,second)
    }

    fun add(a:Int, b:Int) = a + b
}