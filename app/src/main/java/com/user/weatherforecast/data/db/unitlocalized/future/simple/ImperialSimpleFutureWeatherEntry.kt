package com.user.weatherforecast.data.db.unitlocalized.future.simple

import androidx.room.ColumnInfo
import org.threeten.bp.LocalDate

class ImperialSimpleFutureWeatherEntry (
    @ColumnInfo(name = "date")
    override val date: LocalDate,
    @ColumnInfo(name = "mintempF")
    override val minTemperature: Double,
    @ColumnInfo(name = "maxtempF")
    override val maxTemperature: Double,
    @ColumnInfo(name = "condition_text")
    override val conditionText: String,
    @ColumnInfo(name = "condition_icon")
    override val conditionIconUrl: String
) : UnitSpecificSimpleFutureWeatherEntry