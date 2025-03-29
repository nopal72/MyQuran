package com.example.myquran.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myquran.R
import com.example.myquran.data.remote.response.AyatItem
import com.example.myquran.ui.theme.GreenArmy
import com.example.myquran.ui.theme.GreenBase

@Composable
fun ItemAyat(ayat: AyatItem) {
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
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "${ayat.nomorAyat}",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = ayat.teksArab,
                    color = Color.White,
                    fontSize = 28.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Text(
                text = ayat.teksLatin,
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 12.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Arti:",
                color = Color.White,
                fontSize = 12.sp,
            )
            Text(
                text = ayat.teksIndonesia,
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 12.sp,
            )
            Icon(
                painter = painterResource(id = R.drawable.bookmark),
                contentDescription = "bookmark",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.End)
                    .size(28.dp)
            )
        }
    }
}

val ayat = AyatItem(
    nomorAyat = 1,
    teksArab = "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ",
    teksLatin = "Bismillaahhir Rahmaanir Raheem",
    audio = com.example.myquran.data.remote.response.Audio(
        jsonMember01 = "",
        jsonMember02 = "",
        jsonMember03 = "",
        jsonMember04 = "",
        jsonMember05 = ""
    ),
    teksIndonesia = "Bismillaahhir Rahmaanir Raheem"
)

@Preview(showBackground = true)
@Composable
fun ItemAyatPreview(){
    ItemAyat(ayat)
}