package com.walcker.core.data.utils

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(timestamp: Int): String {
    val sdf = SimpleDateFormat("EEE, d MMM")
    val date = Date(timestamp.toLong() * 1000)

    return sdf.format(date)
}

fun formatDateWeek(timestamp: Int): String {
    val sdf = SimpleDateFormat("EEE")
    val date = Date(timestamp.toLong() * 1000)

    return sdf.format(date)
}

fun formatDateTime(timestamp: Int): String {
    val sdf = SimpleDateFormat("hh:mm:aa")
    val date = Date(timestamp.toLong() * 1000)

    return sdf.format(date)
}

fun formatDecimals(item: Double): String {
    return " %.0f".format(item)
}