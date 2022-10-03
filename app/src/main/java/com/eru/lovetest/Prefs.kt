package com.eru.lovetest

import android.content.SharedPreferences
import javax.inject.Inject


class Prefs @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun saveState(){
        sharedPreferences.edit().putBoolean("isShown", true).apply()
    }

    fun isShown():Boolean = sharedPreferences.getBoolean("isShown", false)
}