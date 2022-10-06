package com.eru.lovetest.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.eru.lovetest.model.LoveModel


@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveModel)


    @Query("SELECT * FROM `love-history` ORDER BY firstName ASC")
    fun getAll(): LiveData<List<LoveModel>>
}