package com.example.myquran.data.remote.retrofit

import com.example.myquran.data.remote.response.DetailSuratResponse
import com.example.myquran.data.remote.response.SuratResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("surat")
    fun getSurat(): Call<SuratResponse>

    @GET("surat/{nomor}")
    fun getDetailSurat(@Path("nomor") nomor: Int): Call<DetailSuratResponse>
}