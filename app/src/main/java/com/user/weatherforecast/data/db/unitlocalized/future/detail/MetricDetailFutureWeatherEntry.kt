package com.user.weatherforecast.data.db.unitlocalized.future.detail

import androidx.room.ColumnInfo
import org.threeten.bp.LocalDate

class MetricDetailFutureWeatherEntry (
    @ColumnInfo(name = "date")
    override val date: LocalDate,
    @ColumnInfo(name = "mintempC")
    override val minTemperature: Double,
    @ColumnInfo(name = "maxtempC")
    override val maxTemperature: Double,
    @ColumnInfo(name = "condition_text")
    override val conditionText: String,
    @ColumnInfo(name = "condition_icon")
    override val conditionIconUrl: String,
    @ColumnInfo(name = "maxwindKph")
    override val maxWindSpeed: Double,
    @ColumnInfo(name = "totalprecipMm")
    override val totalPrecipitation: Double,
    @ColumnInfo(name = "avgvisKm")
    override val avgVisibility: Double,
    @ColumnInfo(name = "uv")
    override val uv: Double,
    @ColumnInfo(name = "sunrise")
    override val sunrise: String,
    @ColumnInfo(name = "sunset")
    override val sunset: String
) : UnitSpecificDetailFutureWeatherEntry