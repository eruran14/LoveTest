package com.eru.lovetest.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "love-history")
data class LoveModel(
   @SerializedName("fname")
   val firstName: String,
   @SerializedName("sname")
   val secondName: String,
   val percentage: String,
   val result: String,
   @PrimaryKey(autoGenerate = true)
   val id: Int? = null
)
