package com.eru.lovetest

import android.content.Context
import android.content.SharedPreferences
import com.eru.lovetest.model.LoveApi
import com.eru.lovetest.room.AppDatabase
import com.eru.lovetest.room.LoveDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build().create(LoveApi::class.java)
    }

    @Provides
    fun providePrefs(@ApplicationContext context: Context): SharedPreferences{
        return context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    }

    @Provides
    fun provideDatabase(): AppDatabase = App.appDatabase
}