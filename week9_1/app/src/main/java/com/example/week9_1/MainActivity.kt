package com.example.week9_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week9_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(supportFragmentManager.beginTransaction()){
            val first = FirstFragment()
            replace(R.id.container,first)
        }.commit()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.tab1 -> {
                    with(supportFragmentManager.beginTransaction()) {
                        val first = FirstFragment()
                        replace(R.id.container, first)
                    }.commit()
                }
                R.id.tab2 -> {
                    with(supportFragmentManager.beginTransaction()) {
                        val second = SecondFragment()
                        replace(R.id.container, second)
                    }.commit()
                }
                R.id.tab3 -> {
                    with(supportFragmentManager.beginTransaction()) {
                        val third = ThirdFragment()
                        replace(R.id.container, third)
                    }.commit()
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}