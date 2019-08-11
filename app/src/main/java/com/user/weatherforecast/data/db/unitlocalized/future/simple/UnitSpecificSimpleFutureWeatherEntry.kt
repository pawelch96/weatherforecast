package com.user.weatherforecast.data.db.unitlocalized.future.simple

import org.threeten.bp.LocalDate

interface UnitSpecificSimpleFutureWeatherEntry {
    val date: LocalDate
    val minTemperature: Double
    val maxTemperature: Double
    val conditionText: String
    val conditionIconUrl: String
}