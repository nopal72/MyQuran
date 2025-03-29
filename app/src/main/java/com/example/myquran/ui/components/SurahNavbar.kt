package com.example.myquran.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myquran.ui.theme.GreenMint
import com.example.myquran.ui.theme.GreenNavy

@Composable
fun SurahNavbar(
    nama: String,
    namaLatin: String,
    jumlahAyat: Int,
    tempatTurun: String,
    arti: String
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                brush = Brush.verticalGradient(colors = listOf(GreenMint, GreenNavy)),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(16.dp),
        Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = nama,
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = namaLatin,
                color = Color.White,
                fontSize = 28.sp,
            )
            Text(
                text = "(${arti})",
                color = Color.White,
                fontSize = 12.sp,
            )
            Row {
                Text(
                    text = tempatTurun,
                    color = Color.White,
                    fontSize = 12.sp,
                )
                Text(text = "|", color = Color.White, fontSize = 12.sp, modifier = Modifier.padding(horizontal = 4.dp))
                Text(
                    text = "$jumlahAyat Ayat",
                    color = Color.White,
                    fontSize = 12.sp,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SurahNavbarPreview(){
    SurahNavbar(
        nama = "الفاتحة",
        namaLatin = "Al-Fatihah",
        jumlahAyat = 7,
        tempatTurun = "Mekah",
        arti = "Pembukaan"
    )
}