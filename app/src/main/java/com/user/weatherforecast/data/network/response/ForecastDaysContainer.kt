package com.user.weatherforecast.data.network.response

import com.google.gson.annotations.SerializedName
import com.user.weatherforecast.data.db.entity.FutureWeatherEntry

data class ForecastDaysContainer(
    @SerializedName("forecastday")
    val entries: List<FutureWeatherEntry>
)