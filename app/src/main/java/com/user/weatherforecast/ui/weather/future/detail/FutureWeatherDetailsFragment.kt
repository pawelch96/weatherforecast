package com.user.weatherforecast.ui.weather.future.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.user.weatherforecast.R
import com.user.weatherforecast.data.db.LocalDateConverter
import com.user.weatherforecast.internal.DateNotFoundException
import com.user.weatherforecast.internal.glide.GlideApp
import com.user.weatherforecast.ui.base.ScopedFragment
import kotlinx.android.synthetic.main.future_weather_details_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.factory
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle

class FutureWeatherDetailsFragment : ScopedFragment(), KodeinAware {

    override val kodein by kodein()
    private lateinit var viewModel: FutureWeatherDetailsViewModel
    private val viewModelFactoryInstanceFactory :
            ((LocalDate) -> FutureWeatherDetailsViewModelFactory) by factory()
    private lateinit var date : LocalDate

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.future_weather_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val safeArgs = arguments?.let { FutureWeatherDetailsFragmentArgs.fromBundle(it) }
        date = LocalDateConverter.stringToDate(safeArgs?.dateString) ?: throw DateNotFoundException()

        viewModel = ViewModelProviders.of(this, viewModelFactoryInstanceFactory(date)).get(FutureWeatherDetailsViewModel::class.java)

        bindUI()
    }

    private fun bindUI() = launch {
        val weather = viewModel.weatherDetails.await()

        val weatherLocation = viewModel.weatherLocation.await()

        weatherLocation.observe(this@FutureWeatherDetailsFragment, Observer {location ->
            if (location == null) return@Observer
            updateLocation(location.name)
        })
        weather.observe(this@FutureWeatherDetailsFragment, Observer {
            if (it == null) return@Observer

            group_loading.visibility = View.GONE

            updateDate()
            updateTemperatures(it.minTemperature, it.maxTemperature)
            updateCondition(it.conditionText)
            updatePrecipitation(it.totalPrecipitation)
            updateWind(it.maxWindSpeed)
            updateVisibility(it.avgVisibility)
            updateSunrise(it.sunrise)
            updateSunset(it.sunset)

            GlideApp.with(this@FutureWeatherDetailsFragment)
                .load("https:${it.conditionIconUrl}")
                .into(imageView_condition_icon)

        })
    }

    private fun chooseLocalizedUnitAbbreviation(metric: String, imperial: String): String {
        return if (viewModel.isMetricUnit) metric else imperial
    }

    private fun updateLocation(location: String) {
        (activity as? AppCompatActivity)?.supportActionBar?.title = location
    }

    private fun updateDate() {
        val dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
        (activity as? AppCompatActivity)?.supportActionBar?.subtitle = date.format(dateFormatter)
    }

    private fun updateTemperatures(minTemperature: Double, maxTemperature: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("°C", "°F")
        textView_min_temperature.text = "$minTemperature$unitAbbreviation"
        textView_max_temperature.text = "$maxTemperature$unitAbbreviation"
    }

    private fun updateCondition(condition: String) {
        textView_condition.text = condition
    }

    private fun updatePrecipitation(precipitation: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("mm", "in")
        textView_precipitation.text = "$precipitation $unitAbbreviation"
    }

    private fun updateWind(windSpeed: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("km/h", "mph")
        textView_wind.text = "$windSpeed $unitAbbreviation"
    }

    private fun updateVisibility(visibility: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("km", "mi")
        textView_visibility.text = "$visibility $unitAbbreviation"
    }

    private fun updateSunrise(sunriseTime: String) {
        textView_sunrise.text = sunriseTime
    }

    private fun updateSunset(sunsetTime: String) {
        textView_sunset.text = sunsetTime
    }
}
