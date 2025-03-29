package com.example.myquran.ui.page.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myquran.data.Result
import com.example.myquran.data.remote.response.SuratResponse
import com.example.myquran.ui.components.HomeNavbar
import com.example.myquran.ui.components.ItemSurat
import com.example.myquran.ui.page.ViewModelFactory
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

    Scaffold {innerPadding ->
        Column(
            Modifier.padding(innerPadding)
        ) {
            HomeNavbar()
            when(suratResult){
                is Result.Loading -> {
                    CircularProgressIndicator()
                }
                is Result.Success -> {
                    val surat = (suratResult as Result.Success<SuratResponse>).data
                    LazyColumn {
                        items(surat.data.size){index ->
                            ItemSurat(surat.data[index])
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

@Composable
fun ErrorScreen(errorMessage: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Error: $errorMessage")
    }
}



