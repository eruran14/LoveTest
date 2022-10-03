package com.eru.lovetest

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.eru.lovetest.board.BoardModel
import com.eru.lovetest.model.LoveApi
import com.eru.lovetest.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi){

    fun getLove(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val love: MutableLiveData<LoveModel> = MutableLiveData()
        api.calculateLove(firstName, secondName).enqueue(object : Callback<LoveModel> {
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

    fun loadBoards(data: ArrayList<BoardModel>){
        data.add(BoardModel("Have a good time", "You should take the time to help those who need you", R.drawable.board_1))
        data.add(BoardModel("Cherishing love", "It is now no longer possible for you to cherish love", R.drawable.board_2))
        data.add(BoardModel("Have a breakup?", "We have made a correction for you, don't worry, maybe someone is waiting for you", R.drawable.board_3))
    }


}