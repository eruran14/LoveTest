package com.eru.lovetest

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eru.lovetest.model.LoveModel

class LoveViewModel : ViewModel() {

    private val repository = Repository()

    fun getLiveModel(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLove(firstName, secondName)
    }
}