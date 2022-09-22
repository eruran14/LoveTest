package com.eru.lovetest.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun calculateLove(@Query("fname")firstName:String,
                      @Query("sname")secondName:String,
                      @Header("X-RapidAPI-Key")key:String="515041c643mshfcac81ede225f41p153140jsnd3bc16c9a8c8",
                      @Header("X-RapidAPI-Host")host:String="love-calculator.p.rapidapi.com"):Call<LoveModel>
}