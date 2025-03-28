package com.example.myquran.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun getTodayDate(): String {
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy", Locale("id", "ID"))
    return currentDate.format(formatter)
}