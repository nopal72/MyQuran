package com.example.myquran.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myquran.data.remote.response.SuratResponse
import com.example.myquran.data.remote.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuratRepository private constructor(
    private val apiService: ApiService
){
    fun getSurat(): LiveData<Result<SuratResponse>> {
        val result = MutableLiveData<Result<SuratResponse>>()
        result.value = Result.Loading
        val client = apiService.getSurat()
        client.enqueue(object : Callback<SuratResponse>{
            override fun onResponse(call: Call<SuratResponse>, response: Response<SuratResponse>) {
                if (response.isSuccessful){
                    val body = response.body()
                    body?.let {
                        result.value = Result.Success(it)
                    }
                }else{
                    result.value = Result.Error(response.message())
                }
            }

            override fun onFailure(call: Call<SuratResponse>, t: Throwable) {
                result.value = Result.Error(t.toString())
            }
        })
        return result
    }

    companion object {
        @Volatile
        private var INSTANCE: SuratRepository? = null
        fun getInstance(
            apiService: ApiService
        ): SuratRepository =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: SuratRepository(
                    apiService
                )
            }.also { INSTANCE = it }
    }
}