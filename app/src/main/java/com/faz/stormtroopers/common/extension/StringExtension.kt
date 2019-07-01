package com.faz.stormtroopers.common.extension

import android.annotation.SuppressLint
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit

fun splitToComponentTimes(biggy: Long): IntArray {
    val hours = biggy.toInt() / 3600
    var remainder = biggy.toInt() - hours * 3600
    val minutes = remainder / 60
    remainder -= minutes * 60
    val secs = remainder
    return intArrayOf(hours, minutes, secs)
}


fun convertDuration(millis: Long): String {
    return String.format(
        "%02d:%02d:%02d",
        TimeUnit.MILLISECONDS.toHours(millis),
        TimeUnit.MILLISECONDS.toMinutes(millis) -
                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
        TimeUnit.MILLISECONDS.toSeconds(millis) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
    )
}

@SuppressLint("SimpleDateFormat")
fun calculateTime(input: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val outputFormat = SimpleDateFormat("KK:mm a")
    return outputFormat.format(inputFormat.parse(input))
}

fun numberWithCommas(number: String): String {
    val d = java.lang.Double.parseDouble(number)
    val formatter = DecimalFormat("#,###")
    return formatter.format(d)
}
