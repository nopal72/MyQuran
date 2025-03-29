package com.example.myquran.ui.page.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.myquran.data.Result
import com.example.myquran.data.remote.response.DataItem
import com.example.myquran.data.remote.response.SuratResponse
import com.example.myquran.ui.components.HomeNavbar
import com.example.myquran.ui.components.ItemSurat
import com.example.myquran.ui.page.ViewModelFactory
import com.example.myquran.ui.page.detailSurat.DetailSuratActivity
import com.example.myquran.ui.theme.MyQuranTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyQuranTheme {
                MyQuran(viewModel)
            }
        }
    }
}

@Composable
fun MyQuran(viewModel: MainViewModel) {
    val suratResult by viewModel.getSurat().observeAsState(initial = Result.Loading)
    val context = LocalContext.current

    Scaffold { innerPadding ->
        Column(
            Modifier.padding(innerPadding)
        ) {
            HomeNavbar()
            when(suratResult){
                is Result.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                is Result.Success -> {
                    val surat = (suratResult as Result.Success<SuratResponse>).data
                    LazyColumn {
                        items(surat.data){ suratItem ->
                            ItemSurat(
                                surat = suratItem,
                                onItemClick = {
                                    Log.d("TAG","surat number: ${suratItem.nomor}")
                                    navigateToDetailSurat(context, suratItem)
                                }
                            )
                        }
                    }
                }
                is Result.Error -> {
                    val errorMessage = (suratResult as Result.Error).error
                    ErrorScreen(errorMessage)
                }
            }
        }
    }
}

// Add this function to handle navigation
private fun navigateToDetailSurat(context: Context, surat: DataItem) {
    val intent = Intent(context, DetailSuratActivity::class.java).apply {
                putExtra(DetailSuratActivity.EXTRA_SURAT_NUMBER, surat.nomor)
    }
    Log.d("TAG","surat number: ${surat.nomor}")
    context.startActivity(intent)
}

@Composable
fun ErrorScreen(errorMessage: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Error: $errorMessage")
    }
}