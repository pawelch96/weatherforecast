package com.user.weatherforecast.data.network.response

import com.google.gson.annotations.SerializedName
import com.user.weatherforecast.data.db.entity.WeatherLocation


data class FutureWeatherResponse(
    val location: WeatherLocation,
    @SerializedName("forecast")
    val forecastDaysContainer: ForecastDaysContainer
)