package com.user.weatherforecast.internal

fun String.normalize(): String {
    val original = arrayOf("ą", "ć", "ę", "ł", "ń", "ó", "ś", "ź", "ż")
    val normalized = arrayOf("a", "c", "e", "l", "n", "o", "s", "z", "z")

    return this.map {
        val index = original.indexOf(it.toString())
        if (index >= 0) normalized[index] else it
    }.joinToString("")
}