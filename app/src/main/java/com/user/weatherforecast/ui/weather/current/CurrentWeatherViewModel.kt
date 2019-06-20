package com.user.weatherforecast.ui.weather.current

import com.user.weatherforecast.data.provider.UnitProvider
import com.user.weatherforecast.data.repository.ForecastRepository
import com.user.weatherforecast.internal.lazyDeffered
import com.user.weatherforecast.ui.base.WeatherViewModel

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeffered {
        forecastRepository.getCurrentWeather(super.isMetricUnit)
    }
}
