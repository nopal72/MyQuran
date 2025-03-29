package com.example.myquran.ui.page.detailSurat

import androidx.lifecycle.ViewModel
import com.example.myquran.data.SuratRepository

class DetailSuratViewModel(private val suratRepository: SuratRepository): ViewModel() {
    fun getDetailSurat(nomor: Int) = suratRepository.getDetailSurat(nomor)
}