package com.example.myquran.data.di

import android.content.Context
import com.example.myquran.data.SuratRepository
import com.example.myquran.data.remote.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): SuratRepository{
        val apiService = ApiConfig.getApiService()
        return SuratRepository.getInstance(apiService = apiService)
    }
}