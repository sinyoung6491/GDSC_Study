package com.example.week9_10_movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.week9_10_movie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar) //상단 타이틀에 toolbar설정

        val toggle = ActionBarDrawerToggle(this,binding.drawerLayout,binding.toolbar,R.string.open,R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState() //누르면 나왔다 들어갔다하도록

        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item1 -> {
                    onFragmentSelected(0)
                }
                R.id.item2 -> {
                    onFragmentSelected(1)
                }
                R.id.item3 -> {
                    onFragmentSelected(2)
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START) //왼쪽으로 자동으로 닫도록
            return@setNavigationItemSelectedListener true
        }
    }
    fun onFragmentSelected(index:Int){
        var fragment: Fragment = Fragment()

        when(index){
            0->{
                binding.toolbar.title = "첫번째 화면"
                fragment = FirstFragment()
            }
            1->{
                binding.toolbar.title = "두번째 화면"
                fragment = SecondFragment()
                println("두번째 화면")
            }
            2->{
                binding.toolbar.title = "세번째 화면"
                fragment = ThirdFragment()
                println("세번째 화면")
            }
        }
        with(supportFragmentManager.beginTransaction()){
            replace(R.id.container,fragment)
        }.commit()
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }

    }
}