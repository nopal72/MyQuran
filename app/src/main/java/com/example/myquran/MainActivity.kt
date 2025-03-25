package com.example.myquran

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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


