package com.user.weatherforecast.ui.weather.future.list

import com.user.weatherforecast.data.provider.UnitProvider
import com.user.weatherforecast.data.repository.ForecastRepository
import com.user.weatherforecast.internal.lazyDeffered
import com.user.weatherforecast.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureListWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weatherEntries by lazyDeffered {
        forecastRepository.getFutureWeather(LocalDate.now(), super.isMetricUnit)
    }
}
