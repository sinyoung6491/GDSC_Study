package com.example.week8_6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.week8_6.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        val rootView =  inflater.inflate(R.layout.fragment_login, container, false)

        binding.nextbtn.setOnClickListener {
            val mainActivity = activity as MainActivity //전 화면인 activity의 mainactivity를 참조해서 사용가능
            mainActivity.onFragmentChanged(1)
        }
        return rootView
    }
}