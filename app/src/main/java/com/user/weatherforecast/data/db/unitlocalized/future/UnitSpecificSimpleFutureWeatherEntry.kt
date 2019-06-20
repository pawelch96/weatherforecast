package com.user.weatherforecast.data.db.unitlocalized.future

import org.threeten.bp.LocalDate

interface UnitSpecificSimpleFutureWeatherEntry {
    val date: LocalDate
    val averageTemperature: Double
    val conditionText: String
    val conditionIconUrl: String
}