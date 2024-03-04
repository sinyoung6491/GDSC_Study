package com.example.week6_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.week6_3.databinding.ActivityMainBinding
import com.example.week6_3.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMenuBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            val backIntent = Intent()
            backIntent.putExtra("data","홍길동")
            setResult(201,backIntent)
            finish()
        }
        if(intent != null){
            processIntent(intent)
        }
    }

    fun processIntent(passedIntent: Intent) {
        val mobile = passedIntent.getStringExtra("mobile")
        if (mobile != null) {
            showToast("전달받은 값 : $mobile")
        }
        /*
        mobile?.run {
            showToast("전달받은 값 : $mobile")
        }
        */
    }
    fun showToast(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
}