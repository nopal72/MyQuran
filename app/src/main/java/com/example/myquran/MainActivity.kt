package com.example.myquran

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myquran.ui.components.HomeNavbar
import com.example.myquran.ui.theme.MyQuranTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyQuranTheme {
                MyQuran()
            }
        }
    }
}

@Composable
fun MyQuran(){
    Scaffold {innerPadding ->
        Column(
            Modifier.padding(innerPadding)
        ) {
            HomeNavbar()

            LazyColumn (
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyQuranPreview() {
    MyQuranTheme {
        MyQuran()
    }
}


