package com.eru.lovetest

import android.app.Application
import com.eru.lovetest.model.LoveApi
import com.eru.lovetest.model.RetrofitService

class App:Application() {
    companion object{
        lateinit var api: LoveApi
    }

    override fun onCreate() {
        super.onCreate()
        val retrofitService = RetrofitService()
        api = retrofitService.getLoveApi()
    }
}