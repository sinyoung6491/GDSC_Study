package com.example.week9_10_movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.week9_10_movie.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        val rootView =  inflater.inflate(R.layout.fragment_first, container, false)

        activity?.run {

            binding.pager.adapter = PagerAdapter(supportFragmentManager,lifecycle)
            binding.pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            binding.pager.offscreenPageLimit = 3



            binding.pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    showToast("페이지 선택 : ${position}")
                }
            })
        }

        return rootView
    }
    fun showToast(message:String){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }

    inner class PagerAdapter : FragmentStateAdapter {
        constructor(fm: FragmentManager, lc: Lifecycle) : super(fm, lc)
        override fun getItemCount() = 3

        override fun createFragment(position: Int): Fragment {
            var imageId:Int = 0
            var title:String = ""
            var details1:String = ""
            var details2:String = ""
            var fragment:PageFragment? = null

            when(position) {
                0 -> {
                    imageId = R.drawable.poster1
                    title = "${position+1}. 결백"
                    details1 = "관객수 312,745"
                    details2 = "15세이상 관람가"

                    fragment = PageFragment.newInstance(imageId, title, details1, details2)
                }
                1 -> {
                    imageId = R.drawable.poster2
                    title = "${position+1}. 침입자"
                    details1 = "관객수 166,604"
                    details2 = "15세이상 관람가"

                    fragment = PageFragment.newInstance(imageId, title, details1, details2)
                }
                2 -> {
                    imageId = R.drawable.poster3
                    title = "${position+1}. 에어로너츠"
                    details1 = "관객수 51,608"
                    details2 = "12세이상 관람가"

                    fragment = PageFragment.newInstance(imageId, title, details1, details2)
                }
                else -> {
                    fragment = PageFragment.newInstance(0, "", "", "")
                }
            }

            return fragment
        }
    }
}