package com.user.weatherforecast.data.repository

import androidx.lifecycle.LiveData
import com.user.weatherforecast.data.db.entity.WeatherLocation
import com.user.weatherforecast.data.db.unitlocalized.current.UnitSpecificCurrentWeatherEntry
import com.user.weatherforecast.data.db.unitlocalized.future.UnitSpecificSimpleFutureWeatherEntry
import org.threeten.bp.LocalDate

interface ForecastRepository {
    suspend fun  getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
    suspend fun getFutureWeather(startDate:LocalDate, metric: Boolean): LiveData<out List<UnitSpecificSimpleFutureWeatherEntry>>
    suspend fun  getWeatherLocation(): LiveData<WeatherLocation>
}