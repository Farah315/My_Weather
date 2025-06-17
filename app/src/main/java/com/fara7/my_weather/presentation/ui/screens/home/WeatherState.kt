package com.fara7.my_weather.presentation.ui.screens.home

import com.fara7.my_weather.domain.model.Weather

data class WeatherState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val weatherInformation: Weather? = null
)