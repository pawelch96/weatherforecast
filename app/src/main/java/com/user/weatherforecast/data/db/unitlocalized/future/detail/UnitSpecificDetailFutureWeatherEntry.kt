package com.user.weatherforecast.data.db.unitlocalized.future.detail

import org.threeten.bp.LocalDate

interface UnitSpecificDetailFutureWeatherEntry {
    val date: LocalDate
    val maxTemperature: Double
    val minTemperature: Double
    val conditionText: String
    val conditionIconUrl: String
    val maxWindSpeed: Double
    val totalPrecipitation: Double
    val avgVisibility: Double
    val uv: Double
    val sunrise: String
    val sunset: String
}