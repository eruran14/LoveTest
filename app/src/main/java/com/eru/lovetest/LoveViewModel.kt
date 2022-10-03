package com.eru.lovetest

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eru.lovetest.model.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    fun getLiveModel(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLove(firstName, secondName)
    }
}