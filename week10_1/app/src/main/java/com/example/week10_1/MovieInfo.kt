package com.example.week10_1

data class MovieInfo (
    val rank:String?,           // 순위
    val movieCd:String?,        // 영화 코드
    val movieNm:String?,        // 영화명 (국문)
    val openDt:String?,         // 영화 개봉일
    val audiCnt:String?,        // 해당일의 관객수
    val showCnt:String?
)