package com.user.weatherforecast.ui.weather.future.list

import com.user.weatherforecast.R
import com.user.weatherforecast.data.db.unitlocalized.future.simple.MetricSimpleFutureWeatherEntry
import com.user.weatherforecast.data.db.unitlocalized.future.simple.UnitSpecificSimpleFutureWeatherEntry
import com.user.weatherforecast.internal.glide.GlideApp
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_future_weather.*
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle

class FutureWeatherItem(val weatherEntry: UnitSpecificSimpleFutureWeatherEntry) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.apply {
            textView_condition.text = weatherEntry.conditionText
            updateDate()
            updateTemperature()
            updateConditionIcon()
        }
    }

    override fun getLayout() = R.layout.item_future_weather

    private fun ViewHolder.updateDate() {
        val dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
        textView_date.text = weatherEntry.date.format(dateFormatter)
    }

    private fun ViewHolder.updateTemperature() {
        val unit = if (weatherEntry is MetricSimpleFutureWeatherEntry) "°C"
        else "°F"
        //textView_temperature.text = "${weatherEntry.minTemperature}$unit/${weatherEntry.maxTemperature}$unit"
        textView_temperature_min.text = "${weatherEntry.minTemperature}$unit"
        textView_temperature_max.text = "${weatherEntry.maxTemperature}$unit"
    }

    private fun ViewHolder.updateConditionIcon() {
        GlideApp.with(this.containerView)
            .load("http:" + weatherEntry.conditionIconUrl)
            .into(imageView_condition_icon)
    }
}