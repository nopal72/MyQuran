package com.example.myquran.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myquran.data.remote.response.AudioFull
import com.example.myquran.data.remote.response.DataItem
import com.example.myquran.ui.theme.GreenArmy
import com.example.myquran.ui.theme.GreenBase
import androidx.compose.ui.text.font.FontWeight.Companion as FontWeight1

@Composable
fun ItemSurat(surat: DataItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        GreenBase,
                        GreenArmy
                    )
                ),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(16.dp)
            .height(56.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Nomor Surat
            Box(
                modifier = Modifier
                    .size(40.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${surat.nomor}",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight1.Bold
                )
            }

            // Divider Vertikal
            VerticalDivider(
                color = Color.White.copy(alpha = 0.5f),
                modifier = Modifier
                    .height(40.dp)
                    .width(1.5.dp)
            )

            // Nama Surat dan Jumlah Ayat
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = surat.namaLatin,
                    color = Color.White,
                    fontWeight = FontWeight1.Bold
                )
                Text(
                    text = "${surat.jumlahAyat} ayat",
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 12.sp
                )
            }

            // Nama Arab
            Text(
                text = surat.nama,
                color = Color.White,
                fontSize = 34.sp,
                fontWeight = FontWeight1.Bold,
                modifier = Modifier.padding(end = 16.dp),
                textAlign = TextAlign.End
            )
        }
    }
}

val surat = DataItem(
    nomor = 1,
    nama = "الفاتحة",
    namaLatin = "Al-Fatihah",
    jumlahAyat = 7,
    tempatTurun = "Mekah",
    arti = "Pembukaan",
    deskripsi = "Surat pembuka dalam Al-Quran",
    audioFull = AudioFull(
        jsonMember01 = "",
        jsonMember02 = "",
        jsonMember03 = "",
        jsonMember04 = "",
        jsonMember05 = ""
    )
)

@Preview(showBackground = true)
@Composable
fun ItemSuratPreview(){
    ItemSurat(surat)
}


