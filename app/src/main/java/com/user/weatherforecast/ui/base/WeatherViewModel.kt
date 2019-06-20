package com.user.weatherforecast.ui.base

import androidx.lifecycle.ViewModel
import com.user.weatherforecast.data.provider.UnitProvider
import com.user.weatherforecast.data.repository.ForecastRepository
import com.user.weatherforecast.internal.UnitSystem
import com.user.weatherforecast.internal.lazyDeffered

abstract class WeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {
    private val unitSystem = unitProvider.getUnitSystem()

    val isMetricUnit: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weatherLocation by lazyDeffered {
        forecastRepository.getWeatherLocation()
    }
}