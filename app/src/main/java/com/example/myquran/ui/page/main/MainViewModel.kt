package com.example.myquran.ui.page.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myquran.data.SuratRepository
import com.example.myquran.data.remote.response.SuratResponse
import com.example.myquran.data.Result

class MainViewModel(private val suratRepository: SuratRepository): ViewModel() {
    fun getSurat(): LiveData<Result<SuratResponse>> = suratRepository.getSurat()
}