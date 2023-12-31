package com.gubee.springWithKotlin

import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.util.*

fun LocalDateTime.format(): String = this.format(brazilianDateFormatter)

private val daysLookup = (1..31).associate { it.toLong() to getOrdinal(it) }

private val brazilianDateFormatter = DateTimeFormatterBuilder()
    .appendPattern("dd MMMM yyyy")
    .parseDefaulting(ChronoField.YEAR, LocalDateTime.now().year.toLong())
    .toFormatter(Locale.ENGLISH)


private fun getOrdinal(n: Int) = when {
    n in 11..13 -> "${n}th"
    n % 10 == 1 -> "${n}st"
    n % 10 == 2 -> "${n}nd"
    n % 10 == 3 -> "${n}rd"
    else -> "${n}th"
}

fun String.toSlug() = lowercase(Locale.getDefault())
    .replace("\n", " ")
    .replace("[^a-z\\d\\s]".toRegex(), " ")
    .split(" ")
    .joinToString("-")
    .replace("-+".toRegex(), "-")