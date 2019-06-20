package com.user.weatherforecast.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.user.weatherforecast.data.network.response.CurrentWeatherResponse
import com.user.weatherforecast.data.network.response.FutureWeatherResponse
import com.user.weatherforecast.internal.NoConnectivityException

const val FORECAST_DAYS_COUNT = 7

class WeatherNetworkDataSourceImpl(
    private val weatherApiService: WeatherApiService
) : WeatherNetworkDataSource {

    private val _downloadedForecastWeather = MutableLiveData<FutureWeatherResponse>()
    override val downloadedForecastWeather: LiveData<FutureWeatherResponse>
        get() = _downloadedForecastWeather

    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
        try {
            val fetchedCurrentWeather = weatherApiService
                .getCurrentWeather(location, languageCode)
                .await()
            _downloadedCurrentWeather.postValue(fetchedCurrentWeather)
        } catch (e: NoConnectivityException) {
            Log.e("Connection Error:", "No Internet connection", e)
        }
    }

    override suspend fun fetchForecastWeather(location: String, languageCode: String) {
        try {
            val fetchedForecastWeather = weatherApiService
                .getForecastWeather(location, FORECAST_DAYS_COUNT, languageCode)
                .await()
            _downloadedForecastWeather.postValue(fetchedForecastWeather)
        } catch (e: NoConnectivityException) {
            Log.e("Connection Error:", "No Internet connection", e)
        }
    }
}