package com.example.myquran.ui.page.detailSurat

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.myquran.data.Result
import com.example.myquran.ui.components.SurahNavbar
import com.example.myquran.ui.page.ViewModelFactory
import com.example.myquran.ui.theme.MyQuranTheme
import com.example.myquran.ui.components.ItemAyat


class DetailSuratActivity: ComponentActivity()  {
    private val viewModel by viewModels<DetailSuratViewModel> {
        ViewModelFactory.getInstance(this)
    }

    companion object {
        const val EXTRA_SURAT_NUMBER = "EXTRA_SURAT_NUMBER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyQuranTheme {
                DetailSuratScreen(viewModel, intent.getIntExtra(EXTRA_SURAT_NUMBER, 1))
            }
        }
    }
}

@Composable
fun DetailSuratScreen(viewModel: DetailSuratViewModel, intExtra: Int) {

    val suratResult by viewModel.getDetailSurat(intExtra).observeAsState(initial = Result.Loading)
//    Log.d("TAG", "surat number: $intExtra")
//    Log.d("TAG", "surat data: $suratResult")
    Scaffold {innerPadding ->
        Column (
            Modifier.padding(innerPadding)
        ) {
            when (suratResult) {
                is Result.Loading -> {
                    CircularProgressIndicator()
                }
                is Result.Success -> {
                    val surat = (suratResult as Result.Success).data
                    Log.d("TAG", "datanyaaaaa: $surat")
                    SurahNavbar(
                        nama = surat.data.nama,
                        namaLatin = surat.data.namaLatin,
                        jumlahAyat = surat.data.jumlahAyat,
                        tempatTurun = surat.data.tempatTurun,
                        arti = surat.data.arti
                    )
                    LazyColumn {
                        items(surat.data.ayat){ ayat ->
                            ItemAyat(ayat)
                        }
                    }
                }
                is Result.Error -> {
                    val errorMessage = (suratResult as Result.Error).error
                }
            }
        }
    }
}

