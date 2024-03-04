package com.example.week9_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.week9_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pager.adapter = PagerAdapter(this)
        binding.pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.pager.offscreenPageLimit = 3

        

        binding.pager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                showToast("페이지 선택 : ${position}")
            }
        })

    }
    fun showToast(message:String){
        Toast.makeText(applicationContext,message,Toast.LENGTH_LONG).show()
    }

    inner class PagerAdapter : FragmentStateAdapter{
        constructor(activity:FragmentActivity):super(activity)
        override fun getItemCount() = 3

        override fun createFragment(position: Int): Fragment {
            /*when(position){
                0->{
                    return Fragment1()
                }
                1->{
                    return Fragment2()
                }
                2->{
                    return Fragment3()
                }
                else->{
                    return Fragment1()
                }
            }*/ //이거 간결하게 밑에꺼
            return when(position){
                0->{
                    Fragment1()
                }
                1->{
                    Fragment2()
                }
                2->{
                    Fragment3()
                }
                else->{
                    Fragment1()
                }
            }
        }
    }
}