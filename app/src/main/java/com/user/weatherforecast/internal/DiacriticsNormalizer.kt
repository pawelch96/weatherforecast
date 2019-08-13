package com.user.weatherforecast.internal

fun String.normalize(): String {
    val original = arrayOf("ę", "ą", "ś", "ć", "ź", "ż", "ł", "ń", "ó")
    val normalized =  arrayOf("e", "a", "s", "c", "z", "z", "l", "n", "o")

    return this.map {
        val index = original.indexOf(it.toString())
        if (index >= 0) normalized[index] else it
    }.joinToString("")
}