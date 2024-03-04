package com.example.week10_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.week10_1.data.BoxOfficeResponse
import com.example.week10_1.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        var requestQueue:RequestQueue? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        requestQueue = Volley.newRequestQueue(applicationContext)

        binding.button.setOnClickListener {
            requestBoxOffice()
        }
    }
    fun requestBoxOffice(){
        val apiKey = "fe50e244786280a56c6a98436bb23e0b"
        val requestdate = "20231225"
        val url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=$apiKey&targetDt=$requestdate"
        val request = object: StringRequest(
            Request.Method.GET,
            url,
            {
                //printLog("응답 -> $it")
            processResponse(it)
            },
            {
                printLog("에러 -> ${it.message}")
            }
        ) {
        }
        request.setShouldCache(false)
        requestQueue?.add(request)
        printLog("박스오피스 요청함")
    }

    fun printLog(message:String){
        binding.logOutput.append("$message\n")
    }
    fun processResponse(response:String) {
        val gson = Gson() //gson 객체 생성 -> gson 라이브러리를 이용해서 링크 속 정보들을 객체 안의 속성로 변환
        val boxOfficeResponose = gson.fromJson(response, BoxOfficeResponse::class.java) //클래스로부터 객체를 만들어서 변수에 담음
        printLog("영화 정보의 갯수: " + boxOfficeResponose.boxOfficeResult.dailyBoxOfficeList.size) //영화 정보의 수를 출력

        val movieList = boxOfficeResponose.boxOfficeResult.dailyBoxOfficeList //클래스로부터 영화 리스트 정보를 받아와 변수에 담음
        printLog("1위 영화의 제목 : ${movieList[0].movieNm}") //위에서 선언한 변수를 통해 1위 영화 제목에 대한 내용 출력
    }
}