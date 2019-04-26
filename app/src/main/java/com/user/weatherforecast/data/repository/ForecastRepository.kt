package com.user.weatherforecast.data.repository

import androidx.lifecycle.LiveData
import com.user.weatherforecast.data.db.entity.WeatherLocation
import com.user.weatherforecast.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun  getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
    suspend fun  getWeatherLocation(): LiveData<WeatherLocation>
}