package com.example.myquran.data.remote.retrofit

import com.example.myquran.data.remote.response.SuratResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("surat")
    fun getSurat(): Call<SuratResponse>
}