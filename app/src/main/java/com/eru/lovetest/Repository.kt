package com.eru.lovetest

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.eru.lovetest.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getLove(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val love: MutableLiveData<LoveModel> = MutableLiveData()
        App.api.calculateLove(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                 love.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure ${t.message}")
            }

        })
        return love
    }
}