package com.user.weatherforecast.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.user.weatherforecast.data.provider.UnitProvider
import com.user.weatherforecast.data.repository.ForecastRepository
import com.user.weatherforecast.internal.UnitSystem
import com.user.weatherforecast.internal.lazyDeffered

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {
    private val unitSystem = unitProvider.getUnitSystem()

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeffered {
        forecastRepository.getCurrentWeather(isMetric)
    }

    val weatherLocation by lazyDeffered {
        forecastRepository.getWeatherLocation()
    }
}
