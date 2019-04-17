package com.user.weatherforecast.data.provider

import com.user.weatherforecast.internal.UnitSystem

interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}