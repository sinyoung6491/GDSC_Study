package com.example.week8_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week8_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var loginFragment:LoginFragment = LoginFragment()
    var menuFragment:MenuFragment = MenuFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.showLogin.setOnClickListener {
            //supportFragmentManager.beginTransaction().replace(R.id.container,LoginFragment()).commit()
            //위와 아래 동일
            with(supportFragmentManager.beginTransaction()){
                replace(R.id.container,LoginFragment())
                //추가 코드 작성
            }.commit()

            //onFragmentChanged(0) //Fragment를 바꾸는 함수를 만들어 파라미터를 넘겨줘서 실행
        }
        binding.showMenu.setOnClickListener {
            //supportFragmentManager.beginTransaction().replace(binding.container.id,MenuFragment()).commit()
            with(supportFragmentManager.beginTransaction()){
                replace(binding.container.id,menuFragment) //위에 선언을 미리 해서 사용도 가능
            }.commit()

            //onFragmentChanged(1) //Fragment를 바꾸는 함수를 만들어 파라미터를 넘겨줘서 실행
        }

    }
    fun onFragmentChanged(index:Int){
        when(index){
            0->{
                with(supportFragmentManager.beginTransaction()){
                    replace(R.id.container,LoginFragment())
                }.commit()
            }
            1->{
                with(supportFragmentManager.beginTransaction()){
                    replace(binding.container.id,menuFragment)
                }.commit()
            }
        }
    }
}