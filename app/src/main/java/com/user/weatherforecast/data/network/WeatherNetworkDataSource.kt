package com.user.weatherforecast.data.network

import androidx.lifecycle.LiveData
import com.user.weatherforecast.data.network.response.CurrentWeatherResponse
import com.user.weatherforecast.data.network.response.FutureWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
    val downloadedForecastWeather: LiveData<FutureWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )

    suspend fun fetchForecastWeather(
        location: String,
        languageCode: String
    )
}