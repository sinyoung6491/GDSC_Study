package com.example.week8_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week8_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recyclerView.layoutManager = layoutManager

        val adapter = PersonAdapter()
        adapter.items.add(Person("홍길동1","010-1000-1000"))
        adapter.items.add(Person("홍길동2","010-1000-1000"))
        adapter.items.add(Person("홍길동3","010-1000-1000"))
        binding.recyclerView.adapter = adapter

        adapter.listener = object :OnPersonItemClickListener{
            override fun onItemClick(
                holder: PersonAdapter.ViewHolder?,
                view: View?,
                position: Int
            ) {
                showToast("아이템 클릭됨 : ${position}")
            }
        }
    }
    fun showToast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}