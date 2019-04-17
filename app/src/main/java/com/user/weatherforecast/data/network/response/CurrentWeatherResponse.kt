package com.user.weatherforecast.data.network.response

import com.google.gson.annotations.SerializedName
import com.user.weatherforecast.data.db.entity.CurrentWeatherEntry
import com.user.weatherforecast.data.db.entity.WeatherLoaction

data class CurrentWeatherResponse(
    val location: WeatherLoaction,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)