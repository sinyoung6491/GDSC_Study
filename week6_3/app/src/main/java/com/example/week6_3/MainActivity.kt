package com.example.week6_3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.core.content.edit
import com.example.week6_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.showBtn.setOnClickListener {
            val mobile = "010-1234-1004"
            val showintent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:${mobile}"))
            //showintent.putExtra("mobile","010-1234-1004")
            //startActivityForResult(showintent,101)
            startActivity(showintent)
        }

        showToast("onCreate 호출됨")

        binding.saveBtn.setOnClickListener {
            val input1 = binding.input1.text.toString()
            val pref = getSharedPreferences("pref", MODE_PRIVATE)

            pref.edit().putString("userName",input1).commit()
            //위에랑 아래 같은 코드 다른 모양 아래 더 권장
            pref.edit {
                putString("userName",input1)
                commit()
            }
        }
        binding.loadBtn.setOnClickListener {
            val pref = getSharedPreferences("pref", MODE_PRIVATE)
            val userName = pref.getString("userName","")
            binding.input1.setText(userName)
        }
    }
    override fun onStart() {
        super.onStart()
        showToast("onStart 호출됨")
    }

    override fun onResume() {
        super.onResume()
        showToast("onResume 호출됨")
    }

    override fun onPause() {
        super.onPause()
        showToast("onPause 호출됨")
    }

    override fun onStop() {
        super.onStop()
        showToast("onStop 호출됨")
    }

    override fun onDestroy() {
        super.onDestroy()
        showToast("onDestroy 호출됨")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            101 -> {
                showToast("메뉴 액티비티에서 응답 받았음 : $requestCode, $resultCode")

                if(data != null){
                    processIntent(data)
                }
            }
        }
    }
    fun processIntent(passedIntent: Intent){
        val data = passedIntent.getStringExtra("data")
        if(data != null){
            showToast("메뉴 액티비티로부터 전달받은 데이터 : $data")
        }
    }
    fun showToast(message:String){
        Toast.makeText(applicationContext,message, Toast.LENGTH_LONG).show()
    }
}