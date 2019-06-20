package com.user.weatherforecast.data.db.unitlocalized.future

import androidx.room.ColumnInfo
import org.threeten.bp.LocalDate

class MetricSimleFutureWeatherEntry (
    @ColumnInfo(name = "date")
    override val date: LocalDate,
    @ColumnInfo(name = "avgTempC")
    override val averageTemperature: Double,
    @ColumnInfo(name = "condition_text")
    override val conditionText: String,
    @ColumnInfo(name = "condition_icon")
    override val conditionIconUrl: String
) : UnitSpecificSimpleFutureWeatherEntry