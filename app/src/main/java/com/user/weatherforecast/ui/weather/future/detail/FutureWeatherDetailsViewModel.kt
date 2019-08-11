package com.user.weatherforecast.ui.weather.future.detail

import com.user.weatherforecast.data.provider.UnitProvider
import com.user.weatherforecast.data.repository.ForecastRepository
import com.user.weatherforecast.internal.lazyDeffered
import com.user.weatherforecast.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureWeatherDetailsViewModel(
    private val detailDate: LocalDate,
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weatherDetails by lazyDeffered {
        forecastRepository.getFutureWeatherDetails(detailDate, super.isMetricUnit)
    }
}
