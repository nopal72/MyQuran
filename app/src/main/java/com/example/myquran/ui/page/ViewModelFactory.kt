package com.example.myquran.ui.page

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myquran.data.SuratRepository
import com.example.myquran.data.di.Injection
import com.example.myquran.ui.page.detailSurat.DetailSuratViewModel
import com.example.myquran.ui.page.main.MainViewModel

class ViewModelFactory(private val suratRepository: SuratRepository): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
                modelClass.isAssignableFrom(MainViewModel::class.java)->{
                    MainViewModel(suratRepository) as T
                }
                modelClass.isAssignableFrom(DetailSuratViewModel::class.java)->{
                    DetailSuratViewModel(suratRepository) as T
                }
            else -> throw IllegalArgumentException("Unknown model class: "+ modelClass.name)
        }
    }

    companion object{
        @Volatile
        private var INSTANCE: ViewModelFactory? = null
        @JvmStatic
        fun getInstance(context: Context): ViewModelFactory{
            if(INSTANCE == null){
                synchronized(ViewModelProvider::class.java){
                    INSTANCE = ViewModelFactory(Injection.provideRepository(context))
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }
}