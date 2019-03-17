package com.user.weatherforecast.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.user.weatherforecast.data.repository.ForecastRepository
import com.user.weatherforecast.internal.UnitSystem
import com.user.weatherforecast.internal.lazyDeffered

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {
    private val unitSystem = UnitSystem.METRIC // get from settings later

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeffered {
        forecastRepository.getCurrentWeather(isMetric)
    }
}
