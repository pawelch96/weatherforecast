package com.user.weatherforecast.data.db.unitlocalized.future.detail

import androidx.room.ColumnInfo
import org.threeten.bp.LocalDate

data class ImperialDetailFutureWeatherEntry (
    @ColumnInfo(name = "date")
    override val date: LocalDate,
    @ColumnInfo(name = "mintempF")
    override val minTemperature: Double,
    @ColumnInfo(name = "maxtempF")
    override val maxTemperature: Double,
    @ColumnInfo(name = "condition_text")
    override val conditionText: String,
    @ColumnInfo(name = "condition_icon")
    override val conditionIconUrl: String,
    @ColumnInfo(name = "maxwindMph")
    override val maxWindSpeed: Double,
    @ColumnInfo(name = "totalprecipIn")
    override val totalPrecipitation: Double,
    @ColumnInfo(name = "avgvisMiles")
    override val avgVisibility: Double,
    @ColumnInfo(name = "uv")
    override val uv: Double,
    @ColumnInfo(name = "sunrise")
    override val sunrise: String,
    @ColumnInfo(name = "sunset")
    override val sunset: String
    ) : UnitSpecificDetailFutureWeatherEntry