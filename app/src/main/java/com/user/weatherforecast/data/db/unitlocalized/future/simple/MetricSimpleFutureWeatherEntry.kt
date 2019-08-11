package com.user.weatherforecast.data.db.unitlocalized.future.simple

import androidx.room.ColumnInfo
import org.threeten.bp.LocalDate

class MetricSimpleFutureWeatherEntry (
    @ColumnInfo(name = "date")
    override val date: LocalDate,
    @ColumnInfo(name = "mintempC")
    override val minTemperature: Double,
    @ColumnInfo(name = "maxtempC")
    override val maxTemperature: Double,
    @ColumnInfo(name = "condition_text")
    override val conditionText: String,
    @ColumnInfo(name = "condition_icon")
    override val conditionIconUrl: String
) : UnitSpecificSimpleFutureWeatherEntry